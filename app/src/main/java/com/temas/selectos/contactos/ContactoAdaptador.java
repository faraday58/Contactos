package com.temas.selectos.contactos;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter <ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos,Activity activity)
    {
        this.contactos = contactos;
        this.activity = activity;
    }


    @NonNull
    @Override
    public ContactoViewHolder  onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_contacto,viewGroup,false);

        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int posicion) {
            final Contacto contacto = contactos.get(posicion);
            contactoViewHolder.txtv_correo.setText(contacto.getCorreo());
            contactoViewHolder.txtv_telefono.setText(contacto.getTelefono());
            contactoViewHolder.imgFoto.setImageResource(contacto.getIdFoto());

            contactoViewHolder.imgbTelefono.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String telefono = contacto.getTelefono();
                    if (ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                    {
                        return;
                    }
                    activity.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono)));

                }
            });

            contactoViewHolder.imgbCorreo.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    String[] correo = {contacto.getCorreo()};
                    if (ActivityCompat.checkSelfPermission(v.getContext(),Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED)
                    {
                        return;
                    }
                    Intent mailIntent = new Intent(Intent.ACTION_SEND);
                    mailIntent.setData(Uri.parse("mailto:"));
                    mailIntent.setType("text/plain");

                    mailIntent.putExtra(Intent.EXTRA_EMAIL,correo);
                    mailIntent.putExtra(Intent.EXTRA_SUBJECT,"mi mansaje de contacto");
                    mailIntent.putExtra(Intent.EXTRA_TEXT,"Este es mi mensaje enviado desde mi app");
                    try
                    {
                        activity.startActivity(Intent.createChooser(mailIntent,"Enviar correo..."));
                        activity.finish();
                        Log.i("Finaliza envio","Proceso de envío");
                    }catch (ActivityNotFoundException ex )
                    {
                        Toast.makeText(v.getContext(),"No hay cliente para manipular correos",Toast.LENGTH_LONG).show();
                    }

                }
            });

    }




    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView txtv_correo;
        private TextView txtv_telefono;
        private ImageButton imgbTelefono;
        private ImageButton imgbCorreo;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            txtv_telefono =itemView.findViewById(R.id.txtvTelefono);
            txtv_correo = itemView.findViewById(R.id.txtvCorreo);
            imgbCorreo = itemView.findViewById(R.id.imgbCorreo);
            imgbTelefono = itemView.findViewById(R.id.imgbTelefono);

        }
    }
}

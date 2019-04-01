package com.temas.selectos.contactos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter <ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;

    public ContactoAdaptador(ArrayList<Contacto> contactos)
    {
        this.contactos = contactos;
    }


    @NonNull
    @Override
    public ContactoViewHolder  onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_contacto,viewGroup,false);

        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int posicion) {
            final Contacto contacto = contactos.get(posicion);
            contactoViewHolder.txtv_correo.setText(contacto.getCorreo());
            contactoViewHolder.txtv_telefono.setText(contacto.getTelefono());
            contactoViewHolder.imgFoto.setImageResource(contacto.getIdFoto());


    }


    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView txtv_correo;
        private TextView txtv_telefono;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            txtv_telefono =itemView.findViewById(R.id.txtvTelefono);
            txtv_correo = itemView.findViewById(R.id.txtvCorreo);
        }
    }
}

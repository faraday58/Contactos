package com.temas.selectos.contactos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EditarContacto extends AppCompatActivity {

    EditText edtTelefono;
    EditText edtCorreo;
    ImageButton imagPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_contacto);
        Bundle extras = getIntent().getExtras();
        String Telefono = extras.getString("Telefono");
        String Correo = extras.getString("Correo");
        imagPerfil = findViewById(R.id.btnImgPerfil);

        edtTelefono = findViewById(R.id.edtTelefono);
        edtCorreo = findViewById(R.id.edtCorreo);

        edtCorreo.setText(Correo);
        edtTelefono.setText(Telefono);


    }
    public void onClickImgPerfil(View v)
    {
        Intent intentCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCamara,0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmapImagen= (Bitmap)data.getExtras().get("data");
        imagPerfil.setImageBitmap(bitmapImagen);
        SalvaImagen(this,bitmapImagen);



    }

    public void SalvaImagen(Context contex,Bitmap Imagen)
    {
        String nombreDirectorio="/CarpetaImagen";
        String nombreArchivo="imagen";
        String  file_path= Environment.getExternalStorageDirectory().getAbsolutePath()+nombreDirectorio;
        String CurrentDateAndTime = getCurrentDateAndTime();

        File dir= new File(file_path);

        if(!dir.exists()){
            dir.mkdirs();
        }
        File file = new File(dir,nombreArchivo+CurrentDateAndTime+".jpg");

        try
        {
            FileOutputStream fo= new FileOutputStream(file);
            Imagen.compress(Bitmap.CompressFormat.JPEG,85,fo);
            fo.flush();
            fo.close();
            VerificaArchivoGuardado(file);
            Toast.makeText(contex,"Se ha guardado la imagen de forma correcta",Toast.LENGTH_LONG).show();

        }catch (FileNotFoundException e)
        {
            Toast.makeText(contex,"No se pudo guardar la imagen", Toast.LENGTH_LONG).show();

        }catch (IOException e)
        {
            Toast.makeText(contex,"No se pudo guardar la imagen", Toast.LENGTH_LONG).show();
        }


    }

    private void VerificaArchivoGuardado(File file) {
        MediaScannerConnection.scanFile(this, new String[]{file.toString()}, null, new MediaScannerConnection.MediaScannerConnectionClient() {
            @Override
            public void onMediaScannerConnected() {

            }

            @Override
            public void onScanCompleted(String path, Uri uri) {

            }
        });
    }

    private String getCurrentDateAndTime() {
        Calendar c= Calendar.getInstance();
        SimpleDateFormat DateForm= new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String formattedDate= DateForm.format(c.getTime());
        return formattedDate;
    }


}

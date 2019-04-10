package com.temas.selectos.contactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EditarContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_contacto);
        Bundle extras = getIntent().getExtras();
        String Telefono = extras.getString("Telefono");
        String Correo = extras.getString("Correo");

    }
}

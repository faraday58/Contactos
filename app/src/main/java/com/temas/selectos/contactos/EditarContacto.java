package com.temas.selectos.contactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditarContacto extends AppCompatActivity {

    EditText edtTelefono;
    EditText edtCorreo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_contacto);
        Bundle extras = getIntent().getExtras();
        String Telefono = extras.getString("Telefono");
        String Correo = extras.getString("Correo");

        edtTelefono = findViewById(R.id.edtTelefono);
        edtCorreo = findViewById(R.id.edtCorreo);

        edtCorreo.setText(Correo);
        edtTelefono.setText(Telefono);


    }
}

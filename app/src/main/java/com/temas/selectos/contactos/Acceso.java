package com.temas.selectos.contactos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Acceso extends AppCompatActivity {
    EditText edtUsuario;
    EditText edtPassword;
    String Usuario;
    String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword= findViewById(R.id.edtPassword);
        cargarReferencias();
        Usuario= edtUsuario.getText().toString();
        Password= edtPassword.getText().toString();
    }

    public void onClickGuardar(View v)
    {
        //Crear el archivo XML donde se almacenará la información junto con su respectivo permiso
        //Ya no es posible compartir datos con otras aplicaciones mediante SharedPreferences
        SharedPreferences preferencia= getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        Usuario= edtUsuario.getText().toString();
        Password= edtPassword.getText().toString();

        SharedPreferences.Editor editor = preferencia.edit();
        editor.putString("Usuario",Usuario);
        editor.putString("Password",Password);

        Toast.makeText(this,"Datos almacenados",Toast.LENGTH_LONG).show();
        editor.commit();
    }
    public void onClickIngresar(View v)
    {
        if(Usuario.equals("Armando") && Password.equals("armando")  )
        {
            Intent intentAcceso= new Intent(this,MainActivity.class);
            startActivity(intentAcceso);
            finish();
        }


    }

    public void cargarReferencias()
    {
        SharedPreferences preferencia= getSharedPreferences("credenciales",Context.MODE_PRIVATE);
        String Usuario = preferencia.getString("Usuario","No existe información");
        String Password= preferencia.getString("Password","No existe información");

        if(Usuario.contains("No existe información") || Password.contains("No existe información") )
        {
            edtUsuario.setHint(Usuario);
            edtPassword.setHint(Password);
        }
        else
        {
            edtUsuario.setText(Usuario);
            edtPassword.setText(Password);

        }




    }
}

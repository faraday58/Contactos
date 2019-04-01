package com.temas.selectos.contactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contacto> contactos;
    RecyclerView rcListaContactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcListaContactos = findViewById(R.id.rcListaContactos);


    }

    public void IniciarListaContactos()
    {
        contactos = new ArrayList<>();
        contactos.add(new Contacto("55 11 22 13 ","ja@gmail.com",R.drawable.adriana));
        contactos.add(new Contacto("55 11 23 13 ","ka@gmail.com",R.drawable.karla));
        contactos.add(new Contacto("55 10 22 14 ","a@gmail.com",R.drawable.luisa));
    }
}

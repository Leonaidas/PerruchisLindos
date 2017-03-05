package com.appgem.perruchislindos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    ArrayList<ArregloPerruchis> ArregloPerruchiss;
    private RecyclerView listaMascotas;
    public MascotAdaptador  adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        // Hago el RecyclerView rvPerruchis un objeto listaMascotas para poder manipularlo en JAVA
        listaMascotas = (RecyclerView) findViewById(R.id.rvPerruchis);

        ImageView fiveStar = (ImageView) findViewById(R.id.ivStar);
        fiveStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarFavoritos();
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        // Hago que mi objeto RecyclerView listamascotas se comporte como un Linear Layout
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializAdaptador();

    }

    public void mostrarFavoritos(){

        ArrayList<ArregloPerruchis> mascotasFavoritas = adaptador.getMascotasFavoritas();

        if(mascotasFavoritas.size()>0) {

            Intent  intent  =   new Intent(this,DetalleFavoritos.class);
            LogiFav logiFav =   new LogiFav(mascotasFavoritas);
            intent.putExtra("mascotas",logiFav);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Debes calificar una mascota",Toast.LENGTH_LONG).show();
        }

    }

    private void inicializAdaptador (){

        // Inicializa Adaptador
        adaptador = new MascotAdaptador(ArregloPerruchiss);
        listaMascotas.setAdapter(adaptador);

        // Le coloco el adaptador a mi objeto RecyclerView ListaMascotas

    }

    public void inicializarListaMascotas(){

        ArregloPerruchiss = new ArrayList<ArregloPerruchis>();

        //HARDCODEO DE POJO

        ArregloPerruchiss.add(new ArregloPerruchis("Chepo",1,R.drawable.chepo));
        ArregloPerruchiss.add(new ArregloPerruchis("Elbarbas",3,R.drawable.elbarbas));
        ArregloPerruchiss.add(new ArregloPerruchis("Lanudo",9,R.drawable.lanudo));
        ArregloPerruchiss.add(new ArregloPerruchis("Oreo",8,R.drawable.oreo));
        ArregloPerruchiss.add(new ArregloPerruchis("Vainilla",2,R.drawable.vaninilla));

    }

}

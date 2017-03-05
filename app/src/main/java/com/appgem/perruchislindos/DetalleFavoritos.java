package com.appgem.perruchislindos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;

public class DetalleFavoritos extends AppCompatActivity {

    private RecyclerView rvPerruchis;
    private ArrayList<ArregloPerruchis> mascotasFavoritas;
    private MascotAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_favoritos);

        Toolbar toolbar=(Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle llave        =   getIntent().getExtras();
        LogiFav logiFav     =   (LogiFav) llave.get("mascotas");
        mascotasFavoritas   =   logiFav.getMascotasFavoritas();



        rvPerruchis =   (RecyclerView) findViewById(R.id.rvPerruchis);
        LinearLayoutManager llm =new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPerruchis.setLayoutManager(llm);

        inicializAdaptador();
    }

    public void inicializAdaptador(){
        adaptador   =   new MascotAdaptador(mascotasFavoritas);
        rvPerruchis.setAdapter(adaptador);

    }

}

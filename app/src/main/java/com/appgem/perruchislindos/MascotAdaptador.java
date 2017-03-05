package com.appgem.perruchislindos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Usuario on 28/02/2017.
 */

// Ésta clase MascotAdaptador hereda/recibe el RecyclerView y le pasa los elementos (colección de datos
// de tipo MascotaViewHolder) definidos en el ViewHolder. Para accesar a la clase estática MascotaViewHolder se accesa
// a partir del nombre de la clase que contiene dicho elemento, es decir a partir de MascotAdaptador
public class MascotAdaptador extends RecyclerView.Adapter<MascotAdaptador.MascotaViewHolder> {

        ArrayList<ArregloPerruchis> mascotas;
        ArrayList<ArregloPerruchis> mascotasFavoritas   = new ArrayList<ArregloPerruchis>();

        // Metodo Constructor donde pasamos lista de mascotas al adaptador
        public MascotAdaptador (ArrayList<ArregloPerruchis> mascotas){this.mascotas = mascotas;}

        public ArrayList<ArregloPerruchis> getMascotasFavoritas() {
        return mascotasFavoritas;
    }




    @Override
        // Alimenta/Infla el CardView
        public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            // Ésta linea le indica al RecyclerView qué Layout es el que estará Reciclando (en éste caso, dicho Layout es cardview_mascota)
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
            return new MascotaViewHolder(v);

        }

        @Override
        // Pasamos el arreglo de mascotas a cada elemento definido en el constructor de MascotaViewHolder para setear cada uno
        // de los elementos definidos en arreglo mascotas. Quedan en mascota y como mascota es un objeto del tipode arreglo ArregloPerruchis
        // Entonces mascota (por cada posición) cuenta con los getters y setters (definidos en ArregloPerruchis). Position hace un recorrido por
        // cada objeto tipo clase ArregloPerruchis

        public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {

            final ArregloPerruchis mascota = mascotas.get(position);
            mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
            mascotaViewHolder.tvnombrePetCV.setText(mascota.getNombre());
            mascotaViewHolder.tvRatingCV.setText(String.valueOf(mascota.getRating()));

            // Porqué la linea de arriba no puede ingresarse de ésta manera sin que la app
            // se detenga?   mascotaViewHolder.tvRatingCV.setText(mascota.getRating());
            // Revisar lineas equivalentes en el proyecto con nombre ejerciciorecyclerview donde sí funciona

            mascotaViewHolder.imgYellowboneCV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    actualizarRating(mascota,mascotaViewHolder);
                }
            });
        }


    public void actualizarRating(ArregloPerruchis mascota,MascotaViewHolder mascotaViewHolder){
        boolean noEncontrado = true;
        int raiting = mascota.getRating() + 1;
        mascota.setRating(raiting);
        mascotaViewHolder.tvRatingCV.setText(String.valueOf(mascota.getRating()));
        if(mascotasFavoritas.size()==0){
            mascotasFavoritas.add(mascota);
        }else {
            for (ArregloPerruchis tamano : mascotasFavoritas) {
                if (tamano.getNombre().compareTo(mascota.getNombre()) == 0) {
                    noEncontrado = false;
                }
            }
            if(noEncontrado){
                mascotasFavoritas.add(mascota);
            }
        }


    }

    @Override
        public int getItemCount () { return mascotas.size();}



        //Logica de los Views, aplicar herencia
        public static class MascotaViewHolder extends RecyclerView.ViewHolder {

            // Declarar todos los Views presentes en el CardView_Mascota

            private ImageView imgFotoCV;
            //private ImageView imgWhiteboneCV;
            private ImageView imgYellowboneCV;
            private TextView tvnombrePetCV;
            private TextView tvRatingCV;


            //Constructor para traer los textos e imágenes al Adaptador
            public MascotaViewHolder(View itemView) {
                super(itemView);

                imgFotoCV         = (ImageView) itemView.findViewById(R.id.imgFoto);
                tvnombrePetCV     = (TextView) itemView.findViewById(R.id.tvnombrePet);
                tvRatingCV        = (TextView) itemView.findViewById(R.id.tvRating);
                imgYellowboneCV   = (ImageView) itemView.findViewById(R.id.imgYellowbone);

                // imgWhiteboneCV    = (ImageView) itemView.findViewById(R.id.imgWhitebone);

            }

        }

}



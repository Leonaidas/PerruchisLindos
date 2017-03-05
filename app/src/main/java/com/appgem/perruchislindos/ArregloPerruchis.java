package com.appgem.perruchislindos;

/**
 * Created by Usuario on 24/02/2017.
 */

public class ArregloPerruchis {

    private String nombre;
    private int rating;
    private int foto;

    public ArregloPerruchis(String nombre, int rating, int foto) {
        this.nombre = nombre;
        this.rating = rating;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

package com.example.actividad_mascotas;

public class Mascota {

    private String nombre;

    private int rating, imagen;


    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Mascota(String nombre, int rating, int imagen) {
        this.nombre = nombre;
        this.rating = rating;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRating() {
        return rating;
    }
    public int getImagen() {
        return imagen;
    }


}


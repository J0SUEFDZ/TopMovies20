package com.example.josue.top20;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Josue on 23/03/2018.
 */

public class Movie {
    Drawable portada;
    String titulo;
    String meta;
    String rating;

    public Movie(Drawable portada, String titulo, String meta, String rating) {
        this.portada = portada;
        this.titulo = titulo;
        this.meta = meta;
        this.rating = rating;
    }

    public Drawable getPortada() {
        return portada;
    }

    public void setPortada(Drawable portada) {
        this.portada = portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}

package com.example.josue.top20;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Josue on 24/03/2018.
 */

public class ShellIUMovie {
    ImageView portada;
    TextView nombre;
    TextView meta;
    TextView rat;

    public ShellIUMovie(ImageView portada, TextView nombre, TextView meta, TextView rat) {
        this.portada = portada;
        this.nombre = nombre;
        this.meta = meta;
        this.rat = rat;
    }

    public void setPortada(Drawable portada) {
        this.portada.setImageDrawable(portada);
    }

    public void setNombre(String nombre) {
        this.nombre.setText(nombre);
    }

    public void setMeta(String meta) {
        this.meta.setText(meta);
    }

    public void setRat(String rat) {
        this.rat.setText(rat);
    }
}

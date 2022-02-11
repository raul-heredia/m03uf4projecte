package edu.fje.m03uf4projecte;

import java.util.Objects;

public class Libro extends Material{
    private String ISBN;
    private Genero genero;

    public Libro(String titulo, String autor, String anoPublicacion, String ISBN, Genero genero) {
        super(titulo, autor, anoPublicacion);
        this.ISBN = ISBN;
        this.genero = genero;
    }
}

package edu.fje.m03uf4projecte;

import java.util.Calendar;

public class LPapel extends Libro{
    private Calendar fechaImpresion;
    private int cantidadHojas;

    public LPapel(String titulo, String autor, String anoPublicacion, String ISBN, Genero genero, Calendar fechaImpresion, int cantidadHojas) {
        super(titulo, autor, anoPublicacion, ISBN, genero);
        this.fechaImpresion = fechaImpresion;
        this.cantidadHojas = cantidadHojas;
    }
}

package edu.fje.m03uf4projecte;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LPapel extends Libro{
    private String fechaImpresion;
    private int cantidadHojas;

    public LPapel(String titulo, String autor, int anoPublicacion, String ISBN, Genero genero, String fechaImpresion, int cantidadHojas) {
        super(titulo, autor, anoPublicacion, ISBN, genero);
        this.fechaImpresion = fechaImpresion;
        this.cantidadHojas = cantidadHojas;
    }
    public String getTitulo() {
        return super.getTitulo();
    }

    public String getAutor() {
        return super.getAutor();
    }

    public int getAnoPublicacion() {
        return super.getAnoPublicacion();
    }
    public void setTitulo(String titulo) {
        super.setTitulo(titulo);
    }

    public void setAutor(String autor) {
        super.setAutor(autor);
    }

    public void setAnoPublicacion(int anoPublicacion) {
        super.setAnoPublicacion(anoPublicacion);
    }

    public String getISBN() {
        return super.getISBN();
    }

    public void setISBN(String ISBN) {
        super.setISBN(ISBN);
    }

    public Genero getGenero() {
        return super.getGenero();
    }

    public void setGenero(Genero genero) {
        super.setGenero(genero);
    }

    public String getFechaImpresion() {
        return fechaImpresion;
    }

    public void setFechaImpresion(String fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }

    public int getCantidadHojas() {
        return cantidadHojas;
    }

    public void setCantidadHojas(int cantidadHojas) {
        this.cantidadHojas = cantidadHojas;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", fechaImpresion='" + fechaImpresion + '\'' +
                ", cantidadHojas=" + cantidadHojas;
    }
}

package edu.fje.m03uf4projecte;

import java.util.Objects;

public class Libro extends Material{
    private String ISBN;
    private Genero genero;

    public Libro(String titulo, String autor, int anoPublicacion, String ISBN, Genero genero) {
        super(titulo, autor, anoPublicacion);
        this.ISBN = ISBN;
        this.genero = genero;
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
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return  "ISBN='" + ISBN + '\'' +
                ", genero=" + genero +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacion=" + anoPublicacion;
    }
}

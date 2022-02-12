package edu.fje.m03uf4projecte;

public abstract class Material {
    protected String titulo, autor, anoPublicacion;


    public Material(String titulo, String autor, String anoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getAnoPublicacion() {
        return anoPublicacion;
    }
}

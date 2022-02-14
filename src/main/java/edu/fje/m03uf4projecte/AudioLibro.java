package edu.fje.m03uf4projecte;

import java.util.ArrayList;

public class AudioLibro extends Libro{
    private int duracion;

    public AudioLibro(String titulo, String autor, int anoPublicacion, String ISBN, Genero genero, int duracion) {
        super(titulo, autor, anoPublicacion, ISBN, genero);
        this.duracion = duracion;
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
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public static void listarAudioLibroISBN(ArrayList libros, String ISBN){
        Boolean notFound = true;
        for (int i = 0; i < libros.size(); i++) {
            if(libros.get(i) instanceof AudioLibro){
                if (((AudioLibro)libros.get(i)).getISBN().equals(ISBN)) {
                    notFound = false;
                    System.out.println(libros.get(i).toString());
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún Audiolibro con ISBN: " + ISBN);
    }

    public static void modificarAudioLibro(ArrayList libros, String titulo, String autor, int anoPublicacion, String ISBN, Genero genero, int Duracion){
        Boolean notFound = true;
        for (int i = 0; i < libros.size(); i++) {
            if(libros.get(i) instanceof AudioLibro){
                if (((AudioLibro)libros.get(i)).getISBN().equals(ISBN)) {
                    notFound = false;
                    if(!titulo.isEmpty()) ((AudioLibro) libros.get(i)).setTitulo(titulo);
                    if(!autor.isEmpty()) ((AudioLibro) libros.get(i)).setAutor(autor);
                    if(genero != Genero.NoModificar) ((AudioLibro) libros.get(i)).setGenero(genero);
                    if(anoPublicacion != 0) ((AudioLibro) libros.get(i)).setAnoPublicacion(anoPublicacion);
                    if(Duracion != 0) ((AudioLibro) libros.get(i)).setDuracion(Duracion);
                    System.out.println("Libro con ISBN " + ISBN + " Modificado");
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún libro con ISBN: " + ISBN);
    }


    public static void eliminarAudioLibro(ArrayList libros, String ISBN){
        Boolean notFound = true;
        for (int i = 0; i < libros.size(); i++) {
            if(libros.get(i) instanceof AudioLibro){
                if (((AudioLibro)libros.get(i)).getISBN().equals(ISBN)) {
                    notFound = false;
                    libros.remove(i);
                    System.out.println("Libro con ISBN " + ISBN + " Eliminada");
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún libro con ISBN: " + ISBN);
    }
}

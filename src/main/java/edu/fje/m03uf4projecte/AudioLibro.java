package edu.fje.m03uf4projecte;

import java.util.ArrayList;

/**
 * Subclass AudioLibro from Libro
 */
public class AudioLibro extends Libro{
    /**
     * duracion es un integer que especifica la duracion del AudioLibro
     */
    private int duracion;
    /**
     *  Web es una propiedad que relaciona la clase AudioLibro con la clase Web
     */
    private Web web;
    /**
     * Constructor de la Clase AudioLibro
     * @param ISBN string del ISBN del libro
     * @param  genero parametro String que debe ser igual a uno de nuestra lista de generos (equals)
     * @param titulo string del Titulo
     * @param  duracion numero integer de duracion del AudioLibro
     * @param autor string del Autor del AudioLibro
     * @param anoPublicacion string del Año en el que se publico
     */
    public AudioLibro(String titulo, String autor, int anoPublicacion, String ISBN, Genero genero, int duracion) {
        super(titulo, autor, anoPublicacion, ISBN, genero);
        this.duracion = duracion;
    }

    /**
     * Getter de la propiedad Titulo
     * @return String titulo
     */
    public String getTitulo() {
        return super.getTitulo();
    }
    /**
     * Getter de la propiedad Autor
     * @return String autor
     */
    public String getAutor() {
        return super.getAutor();
    }
    /**
     * Getter de la propiedad Año Publicacion
     * @return String anoPublicacion
     */
    public int getAnoPublicacion() {
        return super.getAnoPublicacion();
    }
    /**
     * Setter de la propiedad titulo
     * @param titulo atributo que establece el titulo
     */
    public void setTitulo(String titulo) {
        super.setTitulo(titulo);
    }
    /**
     * Setter de la propiedad autor
     * @param autor atributo que establece el autor
     */
    public void setAutor(String autor) {
        super.setAutor(autor);
    }
    /**
     * Setter de la propiedad Año Publicacion
     * @param anoPublicacion atributo que establece el Año de Publicacion
     */
    public void setAnoPublicacion(int anoPublicacion) {
        super.setAnoPublicacion(anoPublicacion);
    }
    /**
     * Getter de la propiedad ISBN
     * @return String ISBN
     */
    public String getISBN() {
        return super.getISBN();
    }
    /**
     * Setter de la propiedad ISBN
     * @param ISBN atributo que establece el ISBN
     */
    public void setISBN(String ISBN) {
        super.setISBN(ISBN);
    }
    /**
     * Getter de la propiedad Genero
     * @return genero genero
     */
    public Genero getGenero() {
        return super.getGenero();
    }
    /**
     * Setter de la propiedad Genero
     * @param genero atributo que establece el Genero del AudioLibro
     */
    public void setGenero(Genero genero) {
        super.setGenero(genero);
    }
    /**
     * Getter de la propiedad duracion
     * @return int duracion
     */
    public int getDuracion() {
        return duracion;
    }
    /**
     * Setter de la propiedad Duracion
     * @param duracion atributo que establece la duracion
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Metodo para mostrar los Libros
     * @param libros Arralist de libros
     * @param ISBN  String del Libro que quieres buscar, si quieres buscar alguno en concreto
     */
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

    /**
     * Metodo para modificar un Libro
     * @param libros Arraylist donde estan todos los libros
     * @param titulo String titulo que se modificara
     * @param autor String autor que se modificara
     * @param anoPublicacion    String anoPublicacion que se modificara
     * @param ISBN  String ISBN que se modificara
     * @param genero    Nuevo genero que se modificara en el Libro
     * @param Duracion  Nueva duracion del Audiolibro
     */
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
                    System.out.println("Audiolibro con ISBN " + ISBN + " Modificado");
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún Audiolibro con ISBN: " + ISBN);
    }

    /**
     * Metodo para eliminar un Libro
     * @param libros ArrayList de todos los libros
     * @param ISBN  ISBN del libro que se eliminara
     */

    public static void eliminarAudioLibro(ArrayList libros, String ISBN){
        Boolean notFound = true;
        for (int i = 0; i < libros.size(); i++) {
            if(libros.get(i) instanceof AudioLibro){
                if (((AudioLibro)libros.get(i)).getISBN().equals(ISBN)) {
                    notFound = false;
                    libros.remove(i);
                    System.out.println("Audiolibro con ISBN " + ISBN + " Eliminado");
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún Audiolibro con ISBN: " + ISBN);
    }
}

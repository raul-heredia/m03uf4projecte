package edu.fje.m03uf4projecte;

import java.util.Objects;

/**
 * Clase Libro que hereda de Material
 */
public class Libro extends Material{
    /**
     * Propiedad que establece el ISBN del Libro
     */
    private String ISBN;
    /**
     * Propiedad que establece el Genero a través de un Enum
     */
    private Genero genero;

    /**
     * Constructor de la Clase
     * @param titulo Titulo del Libro
     * @param autor Autor del Libro
     * @param anoPublicacion Año Publicacion del Libro
     * @param ISBN ISBN del Libro
     * @param genero Genero del Libro con un Enum
     */
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

    /**
     * Getter de la propiedad ISBN
     * @return String ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Setter de la propiedad ISBN
     * @param ISBN Establece el ISBN del Libro
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Getter de la propiedad Genero
     * @return Genero genero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Seter de la propiedad Genero
     * @param genero Establece el genero del libro a través de un Enum
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro)) return false;
        Libro libro = (Libro) o;
        return getISBN().equals(libro.getISBN());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getISBN());
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

package edu.fje.m03uf4projecte;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase Libro de papel que hereda de Libro
 */
public class LPapel extends Libro{
    /**
     * Propiedad String que indica la fecha de Impresion del Libro
     */
    private String fechaImpresion;
    /**
     * Propiedad integer que indica el numero de hojas del Libro
     */
    private int cantidadHojas;

    /**
     * Constructor de la clase
     * @param titulo Titulo del Libro
     * @param autor Autor del Libro
     * @param anoPublicacion Año de Publicacion del Libro
     * @param ISBN ISBN del Libro
     * @param genero Genero del libro a través de un Enum
     * @param fechaImpresion Fecha de Impresion del Libro
     * @param cantidadHojas Cantidad de Hojas del Libro
     */
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

    /**
     * Getter de la propiedad Fecha Impresion
     * @return String fechaImpresion
     */
    public String getFechaImpresion() {
        return fechaImpresion;
    }
    /**
     * Setter de la propiedad Fecha Impresion
     * @param fechaImpresion Establece la fecha de Impresion del Libro
     */
    public void setFechaImpresion(String fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }

    /**
     * Getter de la Cantidad de Hojas
     * @return int cantidadHojas
     */
    public int getCantidadHojas() {
        return cantidadHojas;
    }

    /**
     * Setter Cantidad Hojas
     * @param cantidadHojas Establece la cantidad de hojas del libro
     */
    public void setCantidadHojas(int cantidadHojas) {
        this.cantidadHojas = cantidadHojas;
    }

    /**
     * Funcion para listar todos o solo un Libro a través de su ISBN
     * @param libros ArraList de todos los Libros
     * @param ISBN ISBN del libro que desea Buscar
     */
    public static void listarLibroISBN(ArrayList libros, String ISBN){
        Boolean notFound = true;
        for (int i = 0; i < libros.size(); i++) {
            if(libros.get(i) instanceof LPapel){
                if (((LPapel)libros.get(i)).getISBN().equals(ISBN)) {
                    notFound = false;
                    System.out.println(libros.get(i).toString());
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún libro con ISBN: " + ISBN);
    }

    /**
     * Funcion para modificar un Libro
     * @param libros ArrayList de libros donde busca el que quieres
     * @param titulo Nuevo titulo del Libro
     * @param autor Nuevo autor del Libro
     * @param anoPublicacion Nuevo año de Publicacion del Libro
     * @param ISBN Nuevo ISBN del Libro
     * @param genero Nuevo Genero del Libro
     * @param fechaImpresion Nueva Fecha de Impresion del Libro
     * @param cantidadHojas Nueva cantidad de Hojas
     */
    public static void modificarLibro(ArrayList libros, String titulo, String autor, int anoPublicacion, String ISBN, Genero genero, String fechaImpresion, int cantidadHojas){
        Boolean notFound = true;
        for (int i = 0; i < libros.size(); i++) {
            if(libros.get(i) instanceof LPapel){
                if (((LPapel)libros.get(i)).getISBN().equals(ISBN)) {
                    notFound = false;
                    if(!titulo.isEmpty()) ((LPapel) libros.get(i)).setTitulo(titulo);
                    if(!autor.isEmpty()) ((LPapel) libros.get(i)).setAutor(autor);
                    if(!fechaImpresion.isEmpty()) ((LPapel) libros.get(i)).setFechaImpresion(fechaImpresion);
                    if(genero != Genero.NoModificar) ((LPapel) libros.get(i)).setGenero(genero);
                    if(anoPublicacion != 0) ((LPapel) libros.get(i)).setAnoPublicacion(anoPublicacion);
                    if(cantidadHojas != 0) ((LPapel) libros.get(i)).setCantidadHojas(cantidadHojas);
                    System.out.println("Libro con ISBN " + ISBN + " Modificado");
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún libro con ISBN: " + ISBN);
    }

    /**
     * Funcion para eliminar un Libro buscandolo a través de su ISBN
     * @param libros ArrayList de libros donde se busca el que quieres
     * @param ISBN ISBN del libro que quieres eliminar
     */
    public static void eliminarLibro(ArrayList libros, String ISBN){
        Boolean notFound = true;
        for (int i = 0; i < libros.size(); i++) {
            if(libros.get(i) instanceof LPapel){
                if (((LPapel)libros.get(i)).getISBN().equals(ISBN)) {
                    notFound = false;
                    libros.remove(i);
                    System.out.println("Libro con ISBN " + ISBN + " Eliminado");
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún libro con ISBN: " + ISBN);
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", fechaImpresion='" + fechaImpresion + '\'' +
                ", cantidadHojas=" + cantidadHojas;
    }
}

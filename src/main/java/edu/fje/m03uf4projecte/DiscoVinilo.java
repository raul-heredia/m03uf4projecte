package edu.fje.m03uf4projecte;

import java.util.ArrayList;

/**
 * Clase Disco vinilo que hereda de la Clase Material, nos sirve para instanciar Discos de Vinilo
 */
public class DiscoVinilo extends Material{
    /**
     * Propiedades integer para: El identificador del Disco, el numero de pistas que tiene y su duracion
     */
    private int idDisco, numPista, duracionDisco;

    /**
     * Constructor de la clase
     * @param idDisco Identificador del Disco
     * @param titulo Titulo del disco
     * @param autor Autor del disco
     * @param anoPublicacion Año de publicacion del disco
     * @param numPista Numero de pistas del disco
     * @param duracionDisco Duracion total del disco
     */
    public DiscoVinilo(int idDisco, String titulo, String autor, int anoPublicacion, int numPista, int duracionDisco) {
        super(titulo, autor, anoPublicacion);
        this.idDisco = idDisco;
        this.numPista = numPista;
        this.duracionDisco = duracionDisco;
    }

    /**
     * Getter de la propiedad IdDisco
     * @return int idDisco
     */
    public int getIdDisco() {
        return idDisco;
    }

    /**
     * Setter de la propiedad idDisco
     * @param idDisco Establece el Identificador del Disco
     */
    public void setIdDisco(int idDisco) {
        this.idDisco = idDisco;
    }

    /**
     * Getter de la propiedas NumPista
     * @return int numPista
     */
    public int getNumPista() {
        return numPista;
    }

    /**
     * Setter de la propiedad NumPista
     * @param numPista Establece el numero de pistas que tiene el disco
     */
    public void setNumPista(int numPista) {
        this.numPista = numPista;
    }

    /**
     * Getter de la propiedad del Disco
     * @return int duracionDisco
     */
    public int getDuracionDisco() {
        return duracionDisco;
    }

    /**
     * Setter de la propiedad Duracion Disco
     * @param duracionDisco Establece la duracion total del disco
     */
    public void setDuracionDisco(int duracionDisco) {
        this.duracionDisco = duracionDisco;
    }

    /**
     * Funcion para listar todos o solo un Disco de Vinilo
     * @param discosVinilo Arraylist de todos los Discos de la biblioteca
     * @param id Identificador del disco en concreto que quiere buscar
     */
    public static void listarDiscoViniloId(ArrayList discosVinilo, int id){
        Boolean notFound = true;
        for (int i = 0; i < discosVinilo.size(); i++) {
            if(discosVinilo.get(i) instanceof DiscoVinilo){
                if (((DiscoVinilo)discosVinilo.get(i)).getIdDisco() == id) {
                    notFound = false;
                    System.out.println(discosVinilo.get(i).toString());
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún Disco de Vinilo con ID: " + id);
    }

    /**
     * Funcion para modificar un Disco de Vinilo
     * @param discosVinilo ArrayList de todos los discos
     * @param idDisco Nuevo Identificador del disco
     * @param titulo    Nuevo titulo del disco
     * @param autor Nuevo autor del disco
     * @param anoPublicacion    Nuevo Año de Publicacion del disco
     * @param numPista Nuevo numero de pistas del disco
     * @param duracionDisco Nueva duracion total del disco
     */
    public static void modificarDiscoVinilo(ArrayList discosVinilo, int idDisco, String titulo, String autor, int anoPublicacion, int numPista, int duracionDisco){
        Boolean notFound = true;
        for (int i = 0; i < discosVinilo.size(); i++) {
            if(discosVinilo.get(i) instanceof DiscoVinilo){
                if (((DiscoVinilo)discosVinilo.get(i)).getIdDisco() == idDisco) {
                    notFound = false;
                    if(!titulo.isEmpty()) ((DiscoVinilo) discosVinilo.get(i)).setTitulo(titulo);
                    if(!autor.isEmpty()) ((DiscoVinilo) discosVinilo.get(i)).setAutor(autor);
                    if(anoPublicacion != 0) ((DiscoVinilo) discosVinilo.get(i)).setAnoPublicacion(anoPublicacion);
                    if(numPista != 0) ((DiscoVinilo) discosVinilo.get(i)).setNumPista(numPista);
                    if(duracionDisco != 0) ((DiscoVinilo) discosVinilo.get(i)).setDuracionDisco(duracionDisco);
                    System.out.println("Disco con ID " + idDisco + " Modificado");
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún disco con ID: " + idDisco);
    }

    /**
     * Funcion para eliminar un Disco de Vinilo
     * @param discosVinilo ArrayList de todos los discos
     * @param id Identificador del Disco que deseas borrar
     */
    public static void eliminarDiscoVinilo(ArrayList discosVinilo, int id){
        Boolean notFound = true;
        for (int i = 0; i < discosVinilo.size(); i++) {
            if(discosVinilo.get(i) instanceof DiscoVinilo){
                if (((DiscoVinilo)discosVinilo.get(i)).getIdDisco() == id) {
                    notFound = false;
                    discosVinilo.remove(i);
                    System.out.println("Disco con ID " + id + " Eliminado");
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún Disco con ID: " + id);
    }

    @Override
    public String toString() {
        return "id=" + idDisco +", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numPista=" + numPista +
                ", duracionDisco=" + duracionDisco +
                ", anoPublicacion=" + anoPublicacion;
    }
}

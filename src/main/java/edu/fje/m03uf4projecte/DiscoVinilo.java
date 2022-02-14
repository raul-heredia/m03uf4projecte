package edu.fje.m03uf4projecte;

import java.util.ArrayList;

public class DiscoVinilo extends Material{
    private int idDisco, numPista, duracionDisco;

    public DiscoVinilo(int idDisco, String titulo, String autor, int anoPublicacion, int numPista, int duracionDisco) {
        super(titulo, autor, anoPublicacion);
        this.idDisco = idDisco;
        this.numPista = numPista;
        this.duracionDisco = duracionDisco;
    }

    public int getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(int idDisco) {
        this.idDisco = idDisco;
    }

    public int getNumPista() {
        return numPista;
    }

    public void setNumPista(int numPista) {
        this.numPista = numPista;
    }

    public int getDuracionDisco() {
        return duracionDisco;
    }

    public void setDuracionDisco(int duracionDisco) {
        this.duracionDisco = duracionDisco;
    }

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

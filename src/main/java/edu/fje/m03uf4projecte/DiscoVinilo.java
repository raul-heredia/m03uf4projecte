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

    @Override
    public String toString() {
        return "id=" + idDisco +", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numPista=" + numPista +
                ", duracionDisco=" + duracionDisco +
                ", anoPublicacion=" + anoPublicacion;
    }
}

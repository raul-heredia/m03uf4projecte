package edu.fje.m03uf4projecte;

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

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numPista=" + numPista +
                ", duracionDisco=" + duracionDisco +
                ", anoPublicacion=" + anoPublicacion;
    }
}

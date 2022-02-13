package edu.fje.m03uf4projecte;

public class DiscoVinilo extends Material{
    private int numPista, duracionDisco;

    public DiscoVinilo(String titulo, String autor, int anoPublicacion, int numPista, int duracionDisco) {
        super(titulo, autor, anoPublicacion);
        this.numPista = numPista;
        this.duracionDisco = duracionDisco;
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
        return "DiscoVinilo{" +
                "numPista=" + numPista +
                ", duracionDisco=" + duracionDisco +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacion='" + anoPublicacion + '\'' +
                '}';
    }
}

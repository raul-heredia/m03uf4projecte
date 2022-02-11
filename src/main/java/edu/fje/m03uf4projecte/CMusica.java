package edu.fje.m03uf4projecte;

public class CMusica extends Cliente{
    private String idEscola;

    public CMusica(String nombre, String email, String direccion, String idEscola) {
        super(nombre, email, direccion);
        this.idEscola = idEscola;
    }

    public String getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(String idEscola) {
        this.idEscola = idEscola;
    }

    @Override
    public String toString() {
        return "CMusica{" +
                "idEscola='" + idEscola + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", carnet=" + carnet +
                '}';
    }
}

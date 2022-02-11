package edu.fje.m03uf4projecte;

public class CPrivado extends Cliente{
    private String nif;

    public CPrivado(String nombre, String email, String direccion, String nif) {
        super(nombre, email, direccion);
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public String toString() {
        return "CPrivado{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", carnet=" + carnet +
                '}';
    }
}

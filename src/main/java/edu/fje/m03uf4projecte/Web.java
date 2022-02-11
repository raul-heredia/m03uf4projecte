package edu.fje.m03uf4projecte;

public class Web {
    private String nombreEmpresa, domSocial;
    private int idWebRegMercantil, telefono;

    public Web(String nombreEmpresa, String domSocial, int idWebRegMercantil, int telefono) {
        this.nombreEmpresa = nombreEmpresa;
        this.domSocial = domSocial;
        this.idWebRegMercantil = idWebRegMercantil;
        this.telefono = telefono;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDomSocial() {
        return domSocial;
    }

    public void setDomSocial(String domSocial) {
        this.domSocial = domSocial;
    }

    public int getIdWebRegMercantil() {
        return idWebRegMercantil;
    }

    public void setIdWebRegMercantil(int idWebRegMercantil) {
        this.idWebRegMercantil = idWebRegMercantil;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}

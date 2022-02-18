package edu.fje.m03uf4projecte;

import java.util.HashSet;

/**
 * Clase de las Webs que dan Audiolibros a la Biblioteca
 */
public class Web {
    /**
     * Propiedades String que establece el nombre y el domicilio social de la Empresa
     */
    private String nombreEmpresa, domSocial;
    /**
     * Propiedades int que establece el id y el telefono de la Empresa
     */
    private int idWebRegMercantil, telefono;
    /**
     * Nuevo HashSet de Audiolibros
     */
    private HashSet<AudioLibro> AudioLibros = new HashSet<AudioLibro>();

    /**
     * Constructor de la clase
     * @param nombreEmpresa Nombre de la Empresa
     * @param domSocial Domicilio Social de la Empresa
     * @param idWebRegMercantil ID del registro mercantil de la Empresa
     * @param telefono Telefono de la Empresa
     */
    public Web(String nombreEmpresa, String domSocial, int idWebRegMercantil, int telefono) {
        this.nombreEmpresa = nombreEmpresa;
        this.domSocial = domSocial;
        this.idWebRegMercantil = idWebRegMercantil;
        this.telefono = telefono;
    }

    /**
     * Getter del nombre de la Empresa
     * @return String nombreEmpresa
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * Setter del nombreEmpresa
     * @param nombreEmpresa Establece el nombre de la Empresa
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * Getter del Domicilio Social
     * @return String domSocial
     */
    public String getDomSocial() {
        return domSocial;
    }

    /**
     * Setter Domicilio Social
     * @param domSocial Establece el domicilio social
     */
    public void setDomSocial(String domSocial) {
        this.domSocial = domSocial;
    }

    /**
     * Getter del Id del Resgitro Mercantil
     * @return int idWebRegMercantil
     */
    public int getIdWebRegMercantil() {
        return idWebRegMercantil;
    }

    /**
     * Setter del ID del Registro Mercantil
     * @param idWebRegMercantil Establece el ID del Registro Mercantil de la empresa
     */
    public void setIdWebRegMercantil(int idWebRegMercantil) {
        this.idWebRegMercantil = idWebRegMercantil;
    }

    /**
     * Getter del Telefono
     * @return int telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Setter del Telefono
     * @param telefono Establece el  telefono de la empresa
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}

package edu.fje.m03uf4projecte;

import java.util.ArrayList;

/**
 * Clase para Escuelas de Musica que hereda de clase Cliente
 */
public class CMusica extends Cliente{
    /**
     * Propiedad para tener un identificador de la Escuela
     */
    private String idEscola;

    /**
     * Constructor de la clase CMusica
     * @param nombre Nombre de la Escuela
     * @param email Correo Electronico de la escuela
     * @param direccion Direccion Fisica de la escuela
     * @param idEscola Identificador de la escuela
     */
    public CMusica(String nombre, String email, String direccion, String idEscola) {
        super(nombre, email, direccion);
        this.idEscola = idEscola;
    }
    public CMusica(String nombre, String email, String direccion, String idEscola, int carnet) {
            super(nombre, email, direccion, carnet);
            this.idEscola = idEscola;
        }

    /**
     * Getter de la propiedad IdEscola
     * @return String IdEscola
     */
    public String getIdEscola() {
        return idEscola;
    }

    /**
     * Setter de la propiedad IdEscola
     * @param idEscola Establece el identificador de la escuela
     */
    public void setIdEscola(String idEscola) {
        this.idEscola = idEscola;
    }

    public String getNombre() {
        return super.getNombre();
    }

    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public String getEmail() {
        return super.getEmail();
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }

    public String getDireccion() {
        return super.getDireccion();
    }

    public void setDireccion(String direccion) {
        super.setDireccion(direccion);
    }

    public int getCarnet() {
        return super.getCarnet();
    }

    public void setCarnet(int carnet) {
        super.setCarnet(carnet);
    }

    public void restarPuntos(int resta) {
        super.restarPuntos(resta);
    }

    /**
     * Funcion la listar todas las Escuelas, pueden buscarse todas o solo una
     * @param clientes ArrayList con todos los clientes de la libreria
     * @param id Identificador de la Escuela que quieras buscar
     */
    public static void listarEscuelaId(ArrayList clientes, String id){
        Boolean notFound = true;
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i) instanceof CMusica){
                if (((CMusica)clientes.get(i)).getIdEscola().equals(id)) {
                    notFound = false;
                    System.out.println(clientes.get(i).toString());
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ninguna Escuela con Identificador: " + id);
    }

    /**
     * Funcion para modificar una Escuela, busca a traves de su ID
     * @param clientes Arralist con todos los clientes
     * @param nombre Nuevo nombre para la Escuela
     * @param email Nuevo email para la Escuela
     * @param direccion Nueva direccion para la Escuela
     * @param id Nuevo ID para la Escuela
     */
    public static void modificarEscuela(ArrayList clientes, String nombre, String email, String direccion, String id){
        Boolean notFound = true;
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i) instanceof CMusica){
                if (((CMusica)clientes.get(i)).getIdEscola().equals(id)) {
                    notFound = false;
                    if(!nombre.isEmpty()) ((CMusica) clientes.get(i)).setNombre(nombre);
                    if(!email.isEmpty()) ((CMusica) clientes.get(i)).setEmail(email);
                    if(!direccion.isEmpty()) ((CMusica) clientes.get(i)).setDireccion(direccion);
                    System.out.println("Escuela con Identificador " + id + " Modificado");
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ninguna escuela con Identificaodr: " + id);
    }

    /**
     * Funcion para eliminar una Escuela
     * @param clientes Arralist con todos los clientes
     * @param id ID de la escuela que quieras eliminar
     */
    public static void eliminarEscuela(ArrayList clientes, String id){
        Boolean notFound = true;
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i) instanceof CMusica){
                if (((CMusica)clientes.get(i)).getIdEscola().equals(id)) {
                    notFound = false;
                    clientes.remove(i);
                    System.out.println("Escuela con identificador " + id + " Eliminada");
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ninguna Escuela con identificador: " + id);
    }


    @Override
    public String toString() {
        return "idEscola='" + idEscola + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", carnet=" + carnet;
    }
}

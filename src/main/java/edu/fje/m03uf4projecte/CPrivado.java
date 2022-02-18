package edu.fje.m03uf4projecte;

import java.util.ArrayList;

/**
 * Clase para los Clientes privados que hereda de la clase Cliente
 */
public class CPrivado extends Cliente{
    /**
     * Propiedad String para asignar un NIF al Cliente
     */
    private String nif;

    /**
     * Constructor de la clase CPrivado
     * @param nombre Nombre del Cliente
     * @param email Email del Cliente
     * @param direccion Direccion Fisica del cliente
     * @param nif Numero identificador del Cliente Privado
     */
    public CPrivado(String nombre, String email, String direccion, String nif) {
        super(nombre, email, direccion);
        this.nif = nif;
    }

    /**
     * Getter de la propiedad NIF
     * @return String nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * Setter de la propiedad Nif
     * @param nif Establece el DNI del cliente
     */
    public void setNif(String nif) {
        this.nif = nif;
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
     * Funcion para listar todos los clientes o solo uno con su NIF
     * @param clientes Arralist de los clientes
     * @param id Nif del Cliente que deseas buscar
     */
    public static void listarClienteDNI(ArrayList clientes, String id){
        Boolean notFound = true;
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i) instanceof CPrivado){
                if (((CPrivado)clientes.get(i)).getNif().equals(id)) {
                    notFound = false;
                    System.out.println(clientes.get(i).toString());
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún cliente con DNI: " + id);
    }

    /**
     * Funcion para Modificar un Cliente
     * @param clientes Array list de clientes
     * @param nombre Nuevo nombre del cliente
     * @param email Nuevo email del cliente
     * @param direccion Nueva direccion del cliente
     * @param id Nuevo NIF del cliente
     */
    public static void modificarCliente(ArrayList clientes, String nombre, String email, String direccion, String id){
        Boolean notFound = true;
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i) instanceof CPrivado){
                if (((CPrivado)clientes.get(i)).getNif().equals(id)) {
                    notFound = false;
                    if(!nombre.isEmpty()) ((CPrivado) clientes.get(i)).setNombre(nombre);
                    if(!email.isEmpty()) ((CPrivado) clientes.get(i)).setEmail(email);
                    if(!direccion.isEmpty()) ((CPrivado) clientes.get(i)).setDireccion(direccion);
                    System.out.println("Cliente con DNI " + id + " Modificado");
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún cliente con DNI: " + id);
    }

    /**
     * Funcion para eliminar un Cliente Privado
     * @param clientes ArrayList de Clientes
     * @param id NIF del cliente que desea eliminar
     */
    public static void eliminarCliente(ArrayList clientes, String id){
        Boolean notFound = true;
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i) instanceof CPrivado){
                if (((CPrivado)clientes.get(i)).getNif().equals(id)) {
                    notFound = false;
                    clientes.remove(i);
                    System.out.println("Cliente con DNI " + id + " Eliminado");
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún cliente con DNI: " + id);
    }


    @Override
    public String toString() {
        return "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", carnet=" + carnet;
    }
}

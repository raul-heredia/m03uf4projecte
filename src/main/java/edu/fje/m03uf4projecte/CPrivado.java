package edu.fje.m03uf4projecte;

import java.util.ArrayList;

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

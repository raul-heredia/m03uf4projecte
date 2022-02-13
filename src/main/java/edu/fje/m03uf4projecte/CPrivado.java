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

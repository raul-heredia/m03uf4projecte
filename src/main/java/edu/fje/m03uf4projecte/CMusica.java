package edu.fje.m03uf4projecte;

import java.util.ArrayList;

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

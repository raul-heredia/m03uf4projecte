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

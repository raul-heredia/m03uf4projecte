package edu.fje.m03uf4projecte;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.TransferQueue;

public class Treballador {
    private String nif, nombre;
    private Boolean isAdmin;
    private Float salario;
    //TRABAJADOR GESTIONA MUCHOS CLIENTE Y MUCHOS MATERIALES, HASHSET ES UNA LISTA
    private ArrayList <Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList <Libro> libros = new ArrayList<Libro>();
    private ArrayList <DiscoVinilo> discosVinilo = new ArrayList<DiscoVinilo>();

    public Treballador(String nif, String nombre, Boolean isAdmin, Float salario, ArrayList<Cliente> clientes, ArrayList<Libro> libros, ArrayList<DiscoVinilo> discosVinilo) {
        this.nif = nif;
        this.nombre = nombre;
        this.isAdmin = isAdmin;
        this.salario = salario;
        this.clientes = clientes;
        this.libros = libros;
        this.discosVinilo = discosVinilo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public ArrayList<DiscoVinilo> getDiscosVinilo() {
        return discosVinilo;
    }

    public void setDiscosVinilo(ArrayList<DiscoVinilo> discosVinilo) {
        this.discosVinilo = discosVinilo;
    }
    //ASOCIACIONES DEL UML, Metodo Introducir Clientes y materiales a las listas
    //public void setClientes (Cliente clclientes.add(client}
    //public void setMateriales (Material matermateriales.add(material}

    public static void listarTrabajadorNIF(ArrayList treballadors, String nif){
        Boolean notFound = true;
        for (int i = 0; i < treballadors.size(); i++) {
            if(treballadors.get(i) instanceof Treballador){
                if (((Treballador)treballadors.get(i)).getNif().equals(nif)) {
                    notFound = false;
                    System.out.println(treballadors.get(i).toString());
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún trabajador con DNI: " + nif);
    }
    public static void modificarTrabajador(ArrayList treballadors, String nif, String nombre, Boolean isAdmin, Float salario){
        Boolean notFound = true;
        for (int i = 0; i < treballadors.size(); i++) {
            if(treballadors.get(i) instanceof Treballador){
                if (((Treballador)treballadors.get(i)).getNif().equals(nif)) {
                    notFound = false;
                    if(!nif.isEmpty()) ((Treballador) treballadors.get(i)).setNif(nif);
                    if(!nombre.isEmpty()) ((Treballador) treballadors.get(i)).setNombre(nombre);
                    if(!isAdmin) ((Treballador) treballadors.get(i)).setAdmin(isAdmin);
                    if(salario != 0) ((Treballador) treballadors.get(i)).setSalario(salario);
                    System.out.println("Empleado con DNI " + nif + " Modificado");
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún trabajador con DNI: " + nif);
    }

    public static void eliminarTrabajador(ArrayList treballadors, String nif){
        Boolean notFound = true;
        for (int i = 0; i < treballadors.size(); i++) {
            if(treballadors.get(i) instanceof Treballador){
                if (((Treballador)treballadors.get(i)).getNif().equals(nif)) {
                    notFound = false;
                    treballadors.remove(i);
                    System.out.println("Trabajador con NIF " + nif + " Eliminado");
                }
            }
        }
        if (notFound) System.out.println("Error, no se ha encontrado ningún libro con ISBN: " + nif);
    }

    @Override
    public String toString() {
        return "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", isAdmin=" + isAdmin +
                ", salario=" + salario;
    }
}

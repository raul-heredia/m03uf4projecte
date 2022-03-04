package edu.fje.m03uf4projecte;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.TransferQueue;

/**
 * Clase para instanciar Trabajadores de la Biblioteca
 */
public class Treballador {
    /**
     * Propiedades String para el NIF y el nombre del trabajador
     */
    private String nif, nombre;
    /**
     * Propiedad Boleana para saber si es admin o no
     */
    private Boolean isAdmin;
    /**
     * Propiedad integer para el salario del trabajador
     */
    private Float salario;
    //TRABAJADOR GESTIONA MUCHOS CLIENTE Y MUCHOS MATERIALES, HASHSET ES UNA LISTA
    /**
     * Arralist de clientes
     */
    private ArrayList <Cliente> clientes = new ArrayList<Cliente>();
    /**
     * Arralist de libros
     */
    private ArrayList <Libro> libros = new ArrayList<Libro>();
    /**
     * Arralist de Discos de Vinilo
     */
    private ArrayList <DiscoVinilo> discosVinilo = new ArrayList<DiscoVinilo>();

    /**
     * Constructor de la clase
     * @param nif NIF del Trabajador
     * @param nombre    Nombre del Trabajador
     * @param isAdmin Si es admin o no el Trabajador
     * @param salario Salario del Trabajador
     * @param clientes Arraylist de clientes
     * @param libros    Arraylist de libros
     * @param discosVinilo Arraylist de Discos de Vinilo
     */
    public Treballador(String nif, String nombre, Boolean isAdmin, Float salario, ArrayList<Cliente> clientes, ArrayList<Libro> libros, ArrayList<DiscoVinilo> discosVinilo) {
        this.nif = nif;
        this.nombre = nombre;
        this.isAdmin = isAdmin;
        this.salario = salario;
        this.clientes = clientes;
        this.libros = libros;
        this.discosVinilo = discosVinilo;
    }

    /**
     * Getter del Nif
     * @return String nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * Setter del Nif
     * @param nif Establece el nif del trabajador
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Getter del Nombre
     * @return String nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del Nombre
     * @param nombre    Establece el nombre del trabajador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de isAdmin
     * @return boolean isAdmin
     */
    public Boolean getAdmin() {
        return isAdmin;
    }

    /**
     * Setter de isAdmin
     * @param admin Establece si el trabajdor es admin o no
     */
    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    /**
     * Getter del Salario
     * @return float salario
     */
    public Float getSalario() {
        return salario;
    }

    /**
     * Setter del Salario
     * @param salario Establece el salario del trabajador
     */
    public void setSalario(Float salario) {
        this.salario = salario;
    }

    /**
     * Getter del ArrayList clientes
     * @return ArrayList clientes
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Setter de ArrayList clientes
     * @param clientes Establece el array de clientes
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     *Getter de Libros
     * @return ArrayList libros
     */
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    /**
     * Setter de Libros
     * @param libros Establece el ArrayList de libros
     */
    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    /**
     * Getter del ArrayList DiscosVinilo
     * @return ArrayList discosVinilo
     */
    public ArrayList<DiscoVinilo> getDiscosVinilo() {
        return discosVinilo;
    }

    /**
     * Setter Discos de Vinilo
     * @param discosVinilo Establece el ArrayList de Discos Vinilo
     */
    public void setDiscosVinilo(ArrayList<DiscoVinilo> discosVinilo) {
        this.discosVinilo = discosVinilo;
    }
    //ASOCIACIONES DEL UML, Metodo Introducir Clientes y materiales a las listas
    //public void setClientes (Cliente clclientes.add(client}
    //public void setMateriales (Material matermateriales.add(material}

    /**
     * Funcion para listar todos los trabajadores o solo uno por su NIF
     * @param treballadors ArrayList de trabajadores
     * @param nif Nif del trabjador que desea buscar
     */
    public static void listarTrabajadorNIF(LinkedList treballadors, String nif){
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

    /**
     * Funcion para modificar el trabajador
     * @param treballadors ArrayList de trabajadores
     * @param nif Nuevo Nif del trabajador
     * @param nombre Nuevo nombre del trabajador
     * @param isAdmin Nuevo isAdmin del trabajador
     * @param salario Nuevo Salario del trabajador
     */
    public static void modificarTrabajador(LinkedList treballadors, String nif, String nombre, Boolean isAdmin, Float salario){
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

    /**
     * Funcion para eliminar un trabajador
     * @param treballadors ArraList de trabajadores
     * @param nif Nif del trabajador que desea borrar
     */
    public static void eliminarTrabajador(LinkedList treballadors, String nif){
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
        if (notFound) System.out.println("Error, no se ha encontrado ningún Usuario con NIF: " + nif);
    }

    @Override
    public String toString() {
        return "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", isAdmin=" + isAdmin +
                ", salario=" + salario;
    }
}

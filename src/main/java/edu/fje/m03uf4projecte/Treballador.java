package edu.fje.m03uf4projecte;

import java.util.HashSet;

public class Treballador {
    protected String nif;
    protected Boolean isAdmin;
    protected Float salario;
    //TRABAJADOR GESTIONA MUCHOS CLIENTE Y MUCHOS MATERIALES, HASHSET ES UNA LISTA
    private HashSet <Cliente> clientes = new HashSet<Cliente>();
    private HashSet<Material> materiales = new HashSet<Material>();

    public Treballador(String nif, Boolean isAdmin, Float salario) {
        this.nif = nif;
        this.salario = salario;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    //ASOCIACIONES DEL UML, Metodo Introducir Clientes y materiales a las listas
    public void setClientes (Cliente cliente){
        clientes.add(cliente);
    }
    public void setMateriales (Material material){
        materiales.add(material);
    }
}

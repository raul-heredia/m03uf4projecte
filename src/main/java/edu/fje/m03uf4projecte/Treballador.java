package edu.fje.m03uf4projecte;

public class Treballador {
    protected String nif;
    protected Boolean isAdmin;
    protected Float salario;

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
}

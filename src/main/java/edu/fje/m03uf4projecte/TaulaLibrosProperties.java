package edu.fje.m03uf4projecte;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TaulaLibrosProperties {
    private final SimpleStringProperty Tipo = new SimpleStringProperty("");
    private final SimpleStringProperty Nombre = new SimpleStringProperty("");
    private final SimpleStringProperty Autor = new SimpleStringProperty("");
    private final SimpleIntegerProperty AnyPublicacion = new SimpleIntegerProperty(0);
    private final SimpleStringProperty ISBN = new SimpleStringProperty("");
    private final SimpleStringProperty Genero = new SimpleStringProperty("");
    private final SimpleStringProperty FechaImpresion = new SimpleStringProperty("");
    private final SimpleIntegerProperty NumeroPaginas = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty Duracion = new SimpleIntegerProperty(0);


    public TaulaLibrosProperties(String t, String no, String au, int an, String isbn, String g, String f, int nu) {
        Tipo.set(t);
        Nombre.set(no);
        Autor.set(au);
        AnyPublicacion.set(an);
        ISBN.set(isbn);
        Genero.set(g);
        FechaImpresion.set(f);
        NumeroPaginas.set(nu);
        Duracion.set(0);
    }
    public TaulaLibrosProperties(String t, String no, String au, int an, String isbn, String g, int du) {
        Tipo.set(t);
        Nombre.set(no);
        Autor.set(au);
        AnyPublicacion.set(an);
        ISBN.set(isbn);
        Genero.set(g);
        FechaImpresion.set("0");
        NumeroPaginas.set(0);
        Duracion.set(du);
    }

    public String getTipo() {
        return Tipo.get();
    }

    public SimpleStringProperty tipoProperty() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        this.Tipo.set(tipo);
    }

    public String getNombre() {
        return Nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre.set(nombre);
    }

    public String getAutor() {
        return Autor.get();
    }

    public SimpleStringProperty autorProperty() {
        return Autor;
    }

    public void setAutor(String autor) {
        this.Autor.set(autor);
    }

    public int getAnyPublicacion() {
        return AnyPublicacion.get();
    }

    public SimpleIntegerProperty anyPublicacionProperty() {
        return AnyPublicacion;
    }

    public void setAnyPublicacion(int anyPublicacion) {
        this.AnyPublicacion.set(anyPublicacion);
    }

    public String getISBN() {
        return ISBN.get();
    }

    public SimpleStringProperty ISBNProperty() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN.set(ISBN);
    }

    public String getGenero() {
        return Genero.get();
    }

    public SimpleStringProperty generoProperty() {
        return Genero;
    }

    public void setGenero(String genero) {
        this.Genero.set(genero);
    }

    public String getFechaImpresion() {
        return FechaImpresion.get();
    }

    public SimpleStringProperty fechaImpresionProperty() {
        return FechaImpresion;
    }

    public void setFechaImpresion(String fechaImpresion) {
        this.FechaImpresion.set(fechaImpresion);
    }

    public int getNumeroPaginas() {
        return NumeroPaginas.get();
    }

    public SimpleIntegerProperty numeroPaginasProperty() {
        return NumeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.NumeroPaginas.set(numeroPaginas);
    }

    public int getDuracion() {
        return Duracion.get();
    }

    public SimpleIntegerProperty duracionProperty() {
        return Duracion;
    }

    public void setDuracion(int duracion) {
        this.Duracion.set(duracion);
    }
}

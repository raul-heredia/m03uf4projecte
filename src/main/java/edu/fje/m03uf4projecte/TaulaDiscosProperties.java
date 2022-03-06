package edu.fje.m03uf4projecte;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * JavaBean preparat per a treballar amb components tipus taula
 * representa una cotització
 * 
 * @author sergi.grau@fje.edu
 * @version 1.0 22.01.2015
 *
 */
public class TaulaDiscosProperties {
	private final SimpleIntegerProperty IdentificadorDisco = new SimpleIntegerProperty(0);
	private final SimpleStringProperty Nombre = new SimpleStringProperty("");
	private final SimpleStringProperty Autor = new SimpleStringProperty("");
	private final SimpleIntegerProperty AnyPublicacion = new SimpleIntegerProperty(0);
	private final SimpleIntegerProperty NumeroPistas = new SimpleIntegerProperty(0);
	private final SimpleIntegerProperty Duracion = new SimpleIntegerProperty(0);

	public TaulaDiscosProperties(){
        this(0,"","",0,0,0);
	}
	
	public TaulaDiscosProperties(int i, String no, String au, int an, int nu, int d) {
		IdentificadorDisco.set(i);
		Nombre.set(no);
		Autor.set(au);
		AnyPublicacion.set(an);
		NumeroPistas.set(nu);
		Duracion.set(d);
	}

	public int getIdentificadorDisco() {
		return IdentificadorDisco.get();
	}

	public SimpleIntegerProperty identificadorDiscoProperty() {
		return IdentificadorDisco;
	}

	public void setIdentificadorDisco(int identificadorDisco) {
		this.IdentificadorDisco.set(identificadorDisco);
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

	public int getNumeroPistas() {
		return NumeroPistas.get();
	}

	public SimpleIntegerProperty numeroPistasProperty() {
		return NumeroPistas;
	}

	public void setNumeroPistas(int numeroPistas) {
		this.NumeroPistas.set(numeroPistas);
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

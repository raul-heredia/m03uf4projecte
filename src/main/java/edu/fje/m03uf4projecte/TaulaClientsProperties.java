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
public class TaulaClientsProperties {
	private final SimpleStringProperty Tipo = new SimpleStringProperty("");
	private final SimpleStringProperty Nombre = new SimpleStringProperty("");
	private final SimpleStringProperty Correo = new SimpleStringProperty("");
	private final SimpleStringProperty Direccion = new SimpleStringProperty("");
	private final SimpleStringProperty Identificador = new SimpleStringProperty("");

	public TaulaClientsProperties(){
        this("", "", "", "", "");
	}
	
	public TaulaClientsProperties(String t, String n, String c, String d, String i) {
		Tipo.set(t);
		Nombre.set(n);
		Correo.set(c);
		Direccion.set(d);
		Identificador.set(i);
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

	public String getCorreo() {
		return Correo.get();
	}

	public SimpleStringProperty correoProperty() {
		return Correo;
	}

	public void setCorreo(String correo) {
		this.Correo.set(correo);
	}

	public String getDireccion() {
		return Direccion.get();
	}

	public SimpleStringProperty direccionProperty() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		this.Direccion.set(direccion);
	}

	public String getIdentificador() {
		return Identificador.get();
	}
}

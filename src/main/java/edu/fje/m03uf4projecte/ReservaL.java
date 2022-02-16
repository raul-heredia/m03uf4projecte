package edu.fje.m03uf4projecte;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservaL {
    private String nif, ISBN;
    private Date dataInic, dataFi;

    public ReservaL(String nif, String ISBN) {
        this.nif = nif;
        this.ISBN = ISBN;
        // Data Inicial
        this.dataInic = new Date();
        // Data Final
        Calendar c = Calendar.getInstance();
        c.setTime(this.dataInic);
        c.add(Calendar.DATE, 15);
        this.dataFi = c.getTime();

    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getDataInic() {
        return dataInic;
    }

    public void setDataInic(Date dataInic) {
        this.dataInic = dataInic;
    }

    public Date getDataFi() {
        return dataFi;
    }

    public void setDataFi(Date dataFi) {
        this.dataFi = dataFi;
    }

    public static void comprobarEstadoLibro(ArrayList reservaLibros, String ISBN){
        Boolean notFound = true;
        for (int i = 0; i < reservaLibros.size(); i++) {
            if(reservaLibros.get(i) instanceof ReservaL){
                if (((ReservaL)reservaLibros.get(i)).getISBN().equals(ISBN)) {
                    notFound = false;
                    System.out.println("El libro con ISBN " + ISBN + " se encuentra en préstamo actualmente");
                }
            }
        }if (notFound) System.out.println("El libro con ISBN " + ISBN + " no se encuentra en préstamo actualmente");
    }

    public static void prestarLibro(ArrayList libros, ArrayList clientes, ArrayList reservaLibros, String ISBN, String nif){
        Boolean isUsuario =false, isLibro =false, isPrestadoLibro = false, isUsuarioConPrestamo =false, tienePuntos = false, isLibroPapel = false, isAudioLibro = false;
        // 1. Comprobar que existe escuela y en caso de que exista comprobar si tiene puntos de carnet.
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i) instanceof CPrivado){
                if (((CPrivado)clientes.get(i)).getNif().equals(nif)) {
                    isUsuario = true;
                    if (((CPrivado)clientes.get(i)).getCarnet() > 0){
                        tienePuntos = true;
                    }
                }
            }
        }
        // 2. Comprobar que existe liBro
        for (int i = 0; i < libros.size(); i++) {
                if (((Libro) libros.get(i)).getISBN().equals(ISBN)) {
                    isLibro = true;
                    if(libros.get(i) instanceof LPapel) isLibroPapel = true;
                    if(libros.get(i) instanceof AudioLibro) isAudioLibro = true;
                }
            }

        if (isUsuario && isLibro && tienePuntos){
            // 4. Comprobar que el libro solicitado no está prestado
            for (int i = 0; i < reservaLibros.size(); i++) {
                if (((ReservaL)reservaLibros.get(i)).getISBN().equals(ISBN)) {
                    isPrestadoLibro = true;
                }
            }
            // 4. Comprobar que el usuario no tiene nada en préstamo
            for (int i = 0; i < reservaLibros.size(); i++) {
                if (((ReservaL)reservaLibros.get(i)).getNif().equals(nif)) {
                    isUsuarioConPrestamo = true;
                }
            }
            // 5. Instanciar présamo y guardar en arraylist reservas.
            if(!isPrestadoLibro && !isUsuarioConPrestamo){
                reservaLibros.add(new ReservaL(nif, ISBN));
                if(isLibroPapel) System.out.println("El libro con ISBN " + ISBN + " ha sido prestado");
                if(isAudioLibro) System.out.println("El Audiolibro con ISBN " + ISBN + " ha sido prestado");
            }else{
                if(isPrestadoLibro) System.out.println("Error, el libro ya está en prestamo");
                if(isUsuarioConPrestamo) System.out.println("Error, el usuario ya tiene un libro en prestamo");
            }
        }else{
            if (!tienePuntos) System.out.println("Error, no quedan puntos en tu carnet, no puedes pedir ningún disco.");
            if(!isUsuario) System.out.println("Error, no existe ningú usuario con DNI: " + nif);
            if(!isLibro) System.out.println("Error, no existe ningun Libro ni AudioLibro con ISBN: " + ISBN);
        }
    }

    public static void devolverlibro(ArrayList clientes,ArrayList reservaLibros, String nif){
        for (int i = 0; i < reservaLibros.size(); i++) {
            if (((ReservaL)reservaLibros.get(i)).getNif().equals(nif)) {
                Date dataDevolucio = new Date();
                long diferenciaMilesimas = ((ReservaL) reservaLibros.get(i)).getDataFi().getTime() - dataDevolucio.getTime();
                int diferenciaDias = (int) TimeUnit.MILLISECONDS.toDays(diferenciaMilesimas);
                if(diferenciaDias < 0){
                    for (int c = 0; c < clientes.size(); c++) {
                        if(clientes.get(c) instanceof CPrivado){
                            if (((CPrivado)clientes.get(c)).getNif().equals(nif)) {
                                int puntosResta = diferenciaDias * -1;
                                ((CPrivado) clientes.get(c)).restarPuntos(puntosResta);
                            }
                        }
                    }
                }
                reservaLibros.remove(i);
                System.out.println("La devolución se ha completado con éxito");
            }else{
                System.out.println("El cliente con identificador " + nif + " no tenía ningún disco reservado.");
            }
        }
    }

    @Override
    public String toString() {
        return "nif='" + nif + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", dataInic=" + dataInic +
                ", dataFi=" + dataFi;
    }
}

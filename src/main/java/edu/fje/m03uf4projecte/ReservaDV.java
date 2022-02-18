package edu.fje.m03uf4projecte;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Clase para instanciar objetos de Reservas de Discos de Vinilo
 */
public class ReservaDV {
    /**
     * Propiedad para poner el Identificador de la Escuela que realiza la reserva
     */
    private String idEscuela;
    /**
     * Propiedad integer para introducir el ID del Disco que se quiere prestar
     */
    private int idDisco;
    /**
     * Propiedad de tipo Date para establecer las fechas de Inicio y Fin
     */
    private Date dataInic, dataFi;

    /**
     * Metodo constructor para crear la reserva
     * @param idDisco Id del disco que quieres reservar
     * @param idEscuela Id de la escuela que quiere realizar la Reserva
     */
    public ReservaDV(int idDisco, String idEscuela) {
        this.idDisco = idDisco;
        this.idEscuela = idEscuela;
        // Data Inicial
        this.dataInic = new Date();
        // Data Final
        Calendar c = Calendar.getInstance();
        c.setTime(this.dataInic);
        c.add(Calendar.DATE, 15);
        this.dataFi = c.getTime();

    }

    /**
     * Getter de la propiedad idDisco
     * @return int idDisco
     */
    public int getIdDisco() {
        return idDisco;
    }

    /**
     * Setter de la propiedad idDisco
     * @param idDisco Establece el id del Disco de Vinilo
     */
    public void setIdDisco(int idDisco) {
        this.idDisco = idDisco;
    }

    /**
     * Getter de la propiedad
     * @return String idEscuela
     */
    public String getIdEscuela() {
        return idEscuela;
    }

    /**
     * Setter de la propiedad idEscuela
     * @param idEscuela Establece el ID de la escuela
     */
    public void setIdEscuela(String idEscuela) {
        this.idEscuela = idEscuela;
    }

    /**
     * Getter de la propiedad Data Inici
     * @return Date dataInic
     */
    public Date getDataInic() {
        return dataInic;
    }

    /**
     * Setter de la propiedad Data Inici
     * @param dataInic Establece la Data inicial del prestamo
     */
    public void setDataInic(Date dataInic) {
        this.dataInic = dataInic;
    }

    /**
     * Getter de la propiedad Data Fi
     * @return Date dataFi
     */
    public Date getDataFi() {
        return dataFi;
    }

    /**
     * Setter de la propiedad Data Fi
     * @param dataFi Establece la data Fi del prestamo
     */
    public void setDataFi(Date dataFi) {
        this.dataFi = dataFi;
    }

    /**
     * Funcion para comprovar si un disco esta prestado
     * @param reservaDiscosVinilo Mira el arraylist de discos vinilo
     * @param idDisco Comprueba con el id del disco si esta prestado
     */
    public static void comprobarEstadoDisco(ArrayList reservaDiscosVinilo, int idDisco){
        Boolean notFound = true;
        for (int i = 0; i < reservaDiscosVinilo.size(); i++) {
            if(reservaDiscosVinilo.get(i) instanceof ReservaDV){
                if (((ReservaDV)reservaDiscosVinilo.get(i)).getIdDisco() == idDisco) {
                    notFound = false;
                    System.out.println("El disco con ID " + idDisco + " se encuentra en préstamo actualmente");
                }
            }
        }if (notFound) System.out.println("El disco con ID " + idDisco + " no se encuentra en préstamo actualmente");
    }

    /**
     * Funcion para prestar Un disco
     * @param discosVinilo Arraylist de los Discos
     * @param clientes Arraylist de los clientes
     * @param reservaDiscosVinilo ArrayList de Reservas de Discos de Vinilo
     * @param idDisco Id del disco que deseas prestar
     * @param idEscuela Id de la escuela que desea realizar el prestamo
     */
    public static void prestarDiscoVinilo(ArrayList discosVinilo, ArrayList clientes, ArrayList reservaDiscosVinilo, int idDisco, String idEscuela){
        Boolean isEscuela =false, isDisco =false, isPrestadoDisco = false, isEscuelaConPrestamo =false, tienePuntos = false;

        // 1. Comprobar que existe escuela y en caso de que exista comprobar si tiene puntos de carnet.
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i) instanceof CMusica){
                if (((CMusica)clientes.get(i)).getIdEscola().equals(idEscuela)) {
                    isEscuela = true;
                    if (((CMusica)clientes.get(i)).getCarnet() > 0){
                        tienePuntos = true;
                    }
                }
            }
        }
        // 2. Comprobar que existe discoVinilo
        for (int i = 0; i < discosVinilo.size(); i++) {
            if (discosVinilo.get(i) instanceof DiscoVinilo) {
                if (((DiscoVinilo) discosVinilo.get(i)).getIdDisco() == idDisco) {
                 isDisco = true;
                }
            }
        }
        if (isEscuela && isDisco && tienePuntos){
            // 3. Comprobar que el disco no está prestado
            for (int i = 0; i < reservaDiscosVinilo.size(); i++) {
                if (((ReservaDV)reservaDiscosVinilo.get(i)).getIdDisco() == idDisco) {
                    isPrestadoDisco = true;
                }
            }
            // 4. Comprobar que la escuela no tiene nada en préstamo
            for (int i = 0; i < reservaDiscosVinilo.size(); i++) {
                if (((ReservaDV)reservaDiscosVinilo.get(i)).getIdEscuela().equals(idEscuela)) {
                    isEscuelaConPrestamo = true;
                }
            }
            // 5. Instanciar préstamo y guardar en arraylist reservas.
            if(!isPrestadoDisco && !isEscuelaConPrestamo){
                reservaDiscosVinilo.add(new ReservaDV(idDisco, idEscuela));
            }else{
                if(isPrestadoDisco) System.out.println("Error, el disco ya está en prestamo");
                if(isEscuelaConPrestamo) System.out.println("Error, la escuela ya tiene un disco en prestamo");
            }
        }else{
            if (!tienePuntos) System.out.println("Error, no quedan puntos en tu carnet, no puedes pedir ningún disco.");
            if(!isEscuela) System.out.println("Error, no existe ninguna escuela con ID: " + idEscuela);
            if(!isDisco) System.out.println("Error, no existe ningun disco con ID: " + idDisco);
        }
}

    /**
     * Funcion para Devolver el prestamo de un Disco
     * @param clientes Arraylist de clientes
     * @param reservaDiscosVinilo ArrayList de reservas de Discos
     * @param idEscuela Id de la escuela que devuelve el libro
     */
    public static void devolverDisco(ArrayList clientes,ArrayList reservaDiscosVinilo, String idEscuela){
        for (int i = 0; i < reservaDiscosVinilo.size(); i++) {
            if (((ReservaDV)reservaDiscosVinilo.get(i)).getIdEscuela().equals(idEscuela)) {
                Date dataDevolucio = new Date();
                long diferenciaMilesimas = ((ReservaDV) reservaDiscosVinilo.get(i)).getDataFi().getTime() - dataDevolucio.getTime();
                int diferenciaDias = (int) TimeUnit.MILLISECONDS.toDays(diferenciaMilesimas);
                if(diferenciaDias < 0){
                    for (int c = 0; c < clientes.size(); c++) {
                        if(clientes.get(c) instanceof CMusica){
                            if (((CMusica)clientes.get(c)).getIdEscola().equals(idEscuela)) {
                                int puntosResta = diferenciaDias * -1;
                                ((CMusica) clientes.get(c)).restarPuntos(puntosResta);
                            }
                        }
                    }
                }
                reservaDiscosVinilo.remove(i);
                System.out.println("La devolución se ha completado con éxito");
            }else{
                System.out.println("La escuela con identificador " + idEscuela + " no tenía ningún disco reservado.");
            }
        }
    }

    @Override
    public String toString() {
        return
                "idEscuela='" + idEscuela + '\'' +
                ", idDisco='" + idDisco + '\'' +
                ", dataInic=" + dataInic +
                ", dataFi=" + dataFi;
    }
}

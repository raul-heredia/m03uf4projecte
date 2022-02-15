package edu.fje.m03uf4projecte;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservaDV {
    private String idEscuela;
    private int idDisco;
    private Date dataInic, dataFi;

    public ReservaDV(int idDisco, String idEscuela) {
        this.idDisco = idDisco;
        this.idEscuela = idEscuela;
        // Data Inicial
        this.dataInic = new Date();
        // Data Final
        Calendar c = Calendar.getInstance();
        c.setTime(this.dataInic);
        c.add(Calendar.DATE, -15);
        this.dataFi = c.getTime();

    }

    public int getIdDisco() {
        return idDisco;
    }
    public void setIdDisco(int idDisco) {
        this.idDisco = idDisco;
    }
    public String getIdEscuela() {
        return idEscuela;
    }
    public void setIdEscuela(String idEscuela) {
        this.idEscuela = idEscuela;
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

    public static void prestarDiscoVinilo(ArrayList discosVinilo, ArrayList clientes, ArrayList reservaDiscosVinilo, int idDisco, String idEscuela){
        Boolean isEscuela =false, isDisco =false, isPrestadoDisco = false, isEscuelaConPrestamo =false, tienePuntos = false;

            // 4. Comprobar que la escuela no tiene nada en préstamo
                // 5. Instanciar présamo y guardar en arraylist reservas.

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
            for (int i = 0; i < reservaDiscosVinilo.size(); i++) {
                if (((ReservaDV)reservaDiscosVinilo.get(i)).getIdDisco() == idDisco) {
                    isPrestadoDisco = true;
                }
            }
            for (int i = 0; i < reservaDiscosVinilo.size(); i++) {
                if (((ReservaDV)reservaDiscosVinilo.get(i)).getIdEscuela().equals(idEscuela)) {
                    isEscuelaConPrestamo = true;
                }
            }
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

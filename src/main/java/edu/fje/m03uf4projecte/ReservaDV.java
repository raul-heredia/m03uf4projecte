package edu.fje.m03uf4projecte;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
        c.add(Calendar.DATE, 15);
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

    public static void prestarDiscoVinilo(ArrayList discosVinilo, ArrayList clientes, ArrayList reservaDiscosVinilo, int idDisco, String idEscuela){
        Boolean isEscuela =false, isDisco =false, isPrestadoDisco = false, isEscuelaConPrestamo =false;

            // 4. Comprobar que la escuela no tiene nada en préstamo
                // 5. Instanciar présamo y guardar en arraylist reservas.

        // 1. Comprobar que existe escuela
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i) instanceof CMusica){
                if (((CMusica)clientes.get(i)).getIdEscola().equals(idEscuela)) {
                    isEscuela = true;
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
        if (isEscuela && isDisco){
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
            if(!isEscuela) System.out.println("Error, no existe ninguna escuela con ID: " + idEscuela);
            if(!isDisco) System.out.println("Error, no existe ningun disco con ID: " + idDisco);
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

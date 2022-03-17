package edu.fje.m03uf4projecte;

import java.util.ArrayList;
import java.util.Iterator;

public class ClaseGenerica1 <T>{
    public T add;
    private ArrayList<ArrayList<ReservaDV>> array;

    public ClaseGenerica1() {
        array = new ArrayList<ArrayList<ReservaDV>>();
    }


    public ArrayList<ArrayList<ReservaDV>> getTreeset() {
        return array;
    }
    public void setTreeset(ArrayList<ArrayList<ReservaDV>> treeset) {
        this.array = treeset;
    }

    public ArrayList<ReservaDV> primer(){
        return array.get(0);
    }
    public ArrayList<ReservaDV> ultim(){
        return array.get(array.size()-1);
    }
    public void afegir(ArrayList<ReservaDV> element){
        array.add(element);
    }

    public String mostrar(){
        Iterator<ArrayList<ReservaDV>> iterator = array.iterator();
        while (iterator.hasNext()){
            ArrayList<ReservaDV> element = iterator.next(); // Creamos un objeto temporal del iterador
                System.out.println(element) ;
        }
        return "";
    }

}

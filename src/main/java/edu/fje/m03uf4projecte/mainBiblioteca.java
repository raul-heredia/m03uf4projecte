package edu.fje.m03uf4projecte;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class mainBiblioteca {
    public static void pressAnyKeyToContinue(){
        System.out.print("Presiona Enter Tecla Para Continuar...");
        try{
            System.in.read();
        } catch(Exception e){}
    }
    public static void main(String[] args) {

        Scanner teclado=new Scanner(System.in).useDelimiter("\n");;
        // ARRAYLIST
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<DiscoVinilo> discosVinilo = new ArrayList<>();

        clientes.add(new CPrivado("Raúl Heredia Maza", "raul.heredia@outlook.com", "C/ Mallorca 666", "21761046X"));
        clientes.add(new CPrivado("Marc Carbonell Sariola", "marc.carbonell@outlook.com", "C/ Pixapins 420", "21007891C"));
        clientes.add(new CPrivado("Juan Martínez Alonso", "juan.martinez@gmail.com", "C/ Sant Andreu 33", "76120965X"));
        clientes.add(new CMusica("Jesuïtes El Clot", "hello.clot@fje.edu", "C/ Valencia 680", "A67890098"));
        clientes.add(new CMusica("Escola Musical del Clot", "escola.musical@musiccclot.edu", "C/ Clot 12", "L77917632"));
        clientes.add(new CMusica("Escola De Música de Barcelona", "hello.musicbarcelona@barcelonamusical.edu", "AV/ Meridiana 396", "A56982014"));

        // VARIABLES
        int op1=99,op2=99; // Declarados en 99 porque el que botón que permite salir es el 0
        do {
            System.out.println("Bienvenido a la Biblioteca Terra Alta");
            System.out.println("¿Que desea Hacer?");
            System.out.println("1 - Gestionar Clientes");
            System.out.println("2 - Gestionar Material");
            System.out.println("3 - Préstamos");
            System.out.println("4 - Gestión de Trabajadores");
            System.out.println("0 - Salir");
            System.out.print("Introduce una opción: ");
            op1=Integer.parseInt(teclado.next());
            op2 = 99; //Reinicia el valor de op2!.
            switch (op1){
                case 1:
                    while (op2 != 0) {
                        System.out.println("Gestión de Clientes");
                        System.out.println("----- Cliente  Privado ----");
                        System.out.println(" 1 - Listar Clientes Privados");
                        System.out.println(" 2 - Buscar Cliente Por DNI");
                        System.out.println(" 3 - Añadir Cliente");
                        System.out.println(" 4 - Modificar Cliente");
                        System.out.println(" 5 - Eliminar Cliente");
                        System.out.println("---- Escuela de Música ----");
                        System.out.println(" 6 - Listar Escuelas de Música");
                        System.out.println(" 7 - Buscar Escuela por Identificador");
                        System.out.println(" 8 - Añadir Escuela");
                        System.out.println(" 9 - Modificar Escuela");
                        System.out.println("10 - Eliminar Escuela");
                        System.out.println(" 0 - Volver Atrás");
                        System.out.print("Introduce una opción: ");
                        op2=Integer.parseInt(teclado.next());

                        if(op2 == 1){
                            Iterator<Cliente> iteratorCliente = clientes.iterator();
                            while (iteratorCliente.hasNext()){
                                Cliente clienteTemp = iteratorCliente.next(); // Creamos un objeto temporal del iterador
                                if(clienteTemp instanceof CPrivado) { // Si el objeto temporal es instancia de CPrivado lo mostramos por pantalla
                                    System.out.println(clienteTemp) ; //  así solo listamos los clientes privados
                                }
                            }
                            pressAnyKeyToContinue();
                        }
                        if (op2 == 2){
                            String dni;
                            System.out.print("Introduzca el DNI del cliente a buscar: ");
                            dni=teclado.next();
                            CPrivado.listarClienteDNI(clientes, dni);
                            pressAnyKeyToContinue();
                        }
                        if(op2 == 3){
                            String nombre, email, direccion, nif;
                            System.out.print("Introduzca el nombre del cliente: ");
                            nombre=teclado.next();
                            System.out.print("Introduzca el email del cliente: ");
                            email=teclado.next();
                            System.out.print("Introduzca la dirección del cliente: ");
                            direccion=teclado.next();
                            System.out.print("Introduzca el DNI del cliente: ");
                            nif=teclado.next();
                            clientes.add(new CPrivado(nombre, email, direccion, nif));
                            System.out.println("Cliente añadido");
                            pressAnyKeyToContinue();
                        }
                        if(op2 == 4){
                            String nombre, email, direccion, nif;
                            System.out.print("Introduzca el DNI del cliente a modificar: ");
                            nif=teclado.next();
                            System.out.print("Introduzca el nuevo nombre del cliente [Dejar en blanco para no modificar]: ");
                            nombre=teclado.next();
                            System.out.print("Introduzca el nuevo email del cliente [Dejar en blanco para no modificar]: ");
                            email=teclado.next();
                            System.out.print("Introduzca la nueva dirección del cliente [Dejar en blanco para no modificar]: ");
                            direccion=teclado.next();
                            CPrivado.modificarCliente(clientes, nombre, email, direccion, nif);
                            pressAnyKeyToContinue();
                        }
                        if(op2 == 5){
                            String dni;
                            System.out.print("Introduzca el DNI del cliente a eliminar: ");
                            dni=teclado.next();
                            CPrivado.eliminarCliente(clientes, dni);
                            pressAnyKeyToContinue();
                        }
                        if(op2 == 6){
                            Iterator<Cliente> iteratorCliente = clientes.iterator();
                            while (iteratorCliente.hasNext()){
                                Cliente escuelaTemp = iteratorCliente.next(); // Creamos un objeto temporal del iterador
                                if(escuelaTemp instanceof CMusica) { // Si el objeto temporal es instancia de CMusica lo mostramos por pantalla
                                    System.out.println(escuelaTemp) ; //  así solo listamos las Escuela de música
                                }
                            }
                            pressAnyKeyToContinue();
                        }
                        if (op2 == 7){

                        }
                        if(op2 == 8){
                            String nombreEscuela, emailEscuela, direccionEscuela, idEscuela;
                            System.out.print("Introduzca el nombre de la Escuela: ");
                            nombreEscuela=teclado.next();
                            System.out.print("Introduzca el email de la Escuela: ");
                            emailEscuela=teclado.next();
                            System.out.print("Introduzca la dirección de la Escuela: ");
                            direccionEscuela=teclado.next();
                            System.out.print("Introduzca el CIF de la Escuela: ");
                            idEscuela=teclado.next();
                            clientes.add(new CMusica(nombreEscuela, emailEscuela, direccionEscuela, idEscuela));
                            System.out.println("Escuela añadida añadido");
                            pressAnyKeyToContinue();
                        }
                        if(op2 == 9){
                            String nombre, email, direccion, idEscuela;
                            System.out.print("Introduzca el Identificador de la Escuela a modificar: ");
                            idEscuela=teclado.next();
                            System.out.print("Introduzca el nuevo nombre de la Escuela [Dejar en blanco para no modificar]: ");
                            nombre=teclado.next();
                            System.out.print("Introduzca el nuevo email de la Escuela [Dejar en blanco para no modificar]: ");
                            email=teclado.next();
                            System.out.print("Introduzca la nueva dirección de la Escuela [Dejar en blanco para no modificar]: ");
                            direccion=teclado.next();
                            CMusica.modificarEscuela(clientes, nombre, email, direccion, idEscuela);
                            pressAnyKeyToContinue();
                        }
                        if(op2 == 10){
                            String idEscuela;
                            System.out.print("Introduzca el Identificador de la escuela a eliminar: ");
                            idEscuela=teclado.next();
                            CMusica.eliminarEscuela(clientes, idEscuela);
                            pressAnyKeyToContinue();
                        }
                    }
                    break;
                case 2:
                    while (op2 != 0) {
                        System.out.println("Gestión de Material");
                        System.out.println("--------- Libros ---------");
                        System.out.println("1 - Añadir Libro");
                        System.out.println("2 - Añadir Audiolibro");
                        System.out.println("3 - Modificar Libro");
                        System.out.println("4 - Modificar Audiolibro");
                        System.out.println("5 - Eliminar Libro");
                        System.out.println("6 - Eliminar Audiolibro");
                        System.out.println("---- Discos De Vinilo ----");
                        System.out.println("7 - Añadir Disco de Vinilo");
                        System.out.println("8 - Modificar Disco de Vinilo");
                        System.out.println("9 - Eliminar Disco de Vinilo");
                        System.out.println("0 - Volver Atrás");
                        System.out.print("Introduce una opción: ");
                        op2=Integer.parseInt(teclado.next());
                    }
                    break;
                case 3:
                    while (op2 != 0) {
                        System.out.println("verduras");
                        System.out.println("1 - espinaca :$100");
                        System.out.println("2- coliflor :$200");
                        System.out.println("3 - zanahoria :$300");
                        System.out.println("4 - tomate :$400");
                        System.out.println("5 - cebolla :$500");
                        System.out.println("6 - volver atras");

                        op2=Integer.parseInt(teclado.next());

                    }
                    break;
            }
        } while (op1!=0);
    }

}

package edu.fje.m03uf4projecte;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

public class mainBiblioteca {
    public static void pressAnyKeyToContinue(){
        System.out.print("Presiona Enter Tecla Para Continuar...");
        try{
            System.in.read();
        } catch(Exception e){}
    }
    public static void main(String[] args) throws ParseException {
        Scanner teclado=new Scanner(System.in).useDelimiter("\n");
        // ARRAYLIST
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<DiscoVinilo> discosVinilo = new ArrayList<>();
        ArrayList<Treballador> trabajadores = new ArrayList<>();
        ArrayList<ReservaDV> reservaDiscosVinilo = new ArrayList<>();
        // Clientes Privados
        clientes.add(new CPrivado("Raúl Heredia Maza", "raul.heredia@outlook.com", "C/ Mallorca 666", "21651036Z"));
        clientes.add(new CPrivado("Marc Carbonell Sariola", "marc.carbonell@outlook.com", "C/ Pixapins 420", "21007891C"));
        clientes.add(new CPrivado("Juan Martínez Alonso", "juan.martinez@gmail.com", "C/ Sant Andreu 33", "76120965X"));
        // Escuelas de musica
        clientes.add(new CMusica("Jesuïtes El Clot", "hello.clot@fje.edu", "C/ Valencia 680", "A67890098"));
        clientes.add(new CMusica("Escola Musical del Clot", "escola.musical@musiccclot.edu", "C/ Clot 12", "L77917632"));
        clientes.add(new CMusica("Escola De Música de Barcelona", "hello.musicbarcelona@barcelonamusical.edu", "AV/ Meridiana 396", "A56982014"));
        // Libros
        libros.add(new LPapel( "Donde Los Escorpiones", "Lorenzo Silva", 2016, "9788423351039", Genero.Thriller,"02/10/2016", 352));
        libros.add(new LPapel( "El Medico", "Noah Gordon", 2013, "9780449214268", Genero.Aventura,"15/04/2013", 608));
        libros.add(new LPapel( "El Cuaderno de Noah", "Nicholas Sparks", 1996, "9780446520805", Genero.Ficcion,"22/07/1997", 224));
        libros.add(new LPapel( "Guerra y paz", "León Tolstói", 1867, "9780192833983", Genero.Novela,"21/02/1995", 1900));
        libros.add(new LPapel( "Ana Karenina", "León Tolstói", 1878, "9780142000274", Genero.Novela,"23/10/2000", 1040));
        libros.add(new LPapel( "La peste", "Albert Camus", 1947, "9780394440613", Genero.Novela,"15/05/1988", 360));
        libros.add(new LPapel( "El extranjero", "Albert Camus", 1942, "9780812416695", Genero.Novela,"28/02/1946", 123));
        libros.add(new LPapel( "Herejes", "Leonardo Padura", 2013, "9786074214666", Genero.Suspense,"05/03/2013", 520));
        libros.add(new LPapel( "Patria", "Fernando Aramburu", 2016, "9781524747121", Genero.Thriller,"05/09/2017", 646));
        // Audio Libros
        libros.add(new AudioLibro("Patria", "Fernando Aramburu", 2019, "9781524747158",Genero.Thriller,3));
        //Disco Vinilo
        discosVinilo.add(new DiscoVinilo(1,"Los éxitos de Manolo Escobar", "Manolo Escobar", 1999, 15, 60));
        discosVinilo.add(new DiscoVinilo(2,"Greatest Hits I, II & III: The Platinum Collection - 3 Discos", "Queen", 2011, 51, 208));
        // TRABAJADORES
        trabajadores.add(new Treballador("23745699Z","Killian",false, 1200F, clientes, libros, discosVinilo));
        // VARIABLES
        int op1=99,op2=99, op3=99, op4=99; // Declarados en 99 porque el que botón que permite salir es el 0

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
                            try{
                                clientes.add(new CPrivado(nombre, email, direccion, nif));
                                System.out.println("Cliente añadido");
                            }catch(Exception e){
                                System.out.println("Error: No se ha añadido el Cliente");
                            }
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
                            String idEscuela;
                            System.out.print("Introduzca el Identificador de la Escuela a buscar: ");
                            idEscuela=teclado.next();
                            CMusica.listarEscuelaId(clientes, idEscuela);
                            pressAnyKeyToContinue();
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
                            try{
                                clientes.add(new CMusica(nombreEscuela, emailEscuela, direccionEscuela, idEscuela));
                                System.out.println("Escuela añadida añadido");
                            }catch(Exception e){
                                System.out.println("Error: No se ha añadido la Escuela");
                            }
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
                    while (op3 != 0) {
                        op3 = 99; //Reinicia el valor de op3!.
                        System.out.println("Gestión de Material");
                        System.out.println("1 - Gestionar Libros");
                        System.out.println("2 - Gestionar Audiolibros");
                        System.out.println("3 - Gestionar Discos De Vinilo");
                        System.out.println("0 - Volver Atrás");
                        System.out.print("Introduce una opción: ");
                        op3=Integer.parseInt(teclado.next());
                        op4 = 99; //Reinicia el valor de op4!.
                        if(op3 == 1){
                            while(op4 != 0){
                                System.out.println("---- Gestión de Libros ----");
                                System.out.println("1 - Listar Libros");
                                System.out.println("1 - Buscar Libro por ISBN");
                                System.out.println("3 - Añadir Libro");
                                System.out.println("4 - Modificar Libro");
                                System.out.println("5 - Eliminar Libro");
                                System.out.println("0 - Volver Atrás");
                                System.out.print("Introduce una opción: ");
                                op4=Integer.parseInt(teclado.next());
                                if(op4 == 1){
                                    Iterator<Libro> libroIterator = libros.iterator();
                                    while (libroIterator.hasNext()){
                                        Libro libroTemp = libroIterator.next(); // Creamos un objeto temporal del iterador
                                        if(libroTemp instanceof LPapel) { // Si el objeto temporal es instancia de CPrivado lo mostramos por pantalla
                                            System.out.println(libroTemp) ; //  así solo listamos los clientes privados
                                        }
                                    }
                                    pressAnyKeyToContinue();
                                }
                                if(op4 == 2){
                                    String ISBN;
                                    System.out.print("Introduzca el ISBN del libro a buscar: ");
                                    ISBN=teclado.next();
                                    LPapel.listarLibroISBN(libros, ISBN);
                                    pressAnyKeyToContinue();
                                }
                                if(op4 == 3){
                                    String titulo, autor, ISBN, fechaImpresion;
                                    int cantidadHojas,anoPublicacion;
                                    Genero genero;

                                    System.out.print("Introduzca el ISBN del libro: ");
                                    ISBN=teclado.next();
                                    System.out.print("Introduzca el título del libro: ");
                                    titulo=teclado.next();
                                    System.out.print("Introduzca el autor del libro: ");
                                    autor=teclado.next();
                                    System.out.print("Introduzca el género del libro de la siguiente lista\n" +
                                            "- Aventura\n" +
                                            "- Ficcion\n" +
                                            "- Fantasia\n" +
                                            "- Misterio\n" +
                                            "- Romance\n" +
                                            "- Thriller\n" +
                                            "- Terror\n" +
                                            "- Suspense\n" +
                                            "- Comedia\n" +
                                            "- Didactico\n" +
                                            "- Novela\n" +
                                            "Introduzca el género: ");
                                    genero=Genero.valueOf(teclado.next());
                                    System.out.print("Introduzca el año de publicación del libro: ");
                                    anoPublicacion=Integer.parseInt(teclado.next());
                                    System.out.print("Introduzca la fecha de impresión del libro [dd/mm/yyyy]: ");
                                    fechaImpresion=teclado.next();
                                    System.out.print("Introduzca el número de hojas del libro: ");
                                    cantidadHojas=Integer.parseInt(teclado.next());
                                    try{
                                        libros.add(new LPapel( titulo, autor, anoPublicacion, ISBN, genero,fechaImpresion, cantidadHojas));
                                        System.out.print("El Libro se ha añadido ");
                                    } catch (Exception e) {
                                        System.out.print("Error: El Libro no se ha añadido ");
                                    }
                                    pressAnyKeyToContinue();
                                }
                                if(op4 == 4){
                                    String titulo, autor, ISBN, fechaImpresion;
                                    int cantidadHojas,anoPublicacion;
                                    Genero genero;

                                    System.out.print("Introduzca el ISBN del libro a modificar: ");
                                    ISBN=teclado.next();
                                    System.out.print("Introduzca el Título del libro [Dejar en blanco para no modificar]: ");
                                    titulo=teclado.next();
                                    System.out.print("Introduzca el autor del libro [Dejar en blanco para no modificar]: ");
                                    autor=teclado.next();
                                    System.out.print("Introduzca el género del libro de la siguiente lista [Dejar en blanco para no modificar]\n" +
                                            "- Aventura\n" +
                                            "- Ficcion\n" +
                                            "- Fantasia\n" +
                                            "- Misterio\n" +
                                            "- Romance\n" +
                                            "- Thriller\n" +
                                            "- Terror\n" +
                                            "- Suspense\n" +
                                            "- Comedia\n" +
                                            "- Didactico\n" +
                                            "- Novela\n" +
                                            "Introduzca el género: ");
                                    try{
                                        genero=Genero.valueOf(teclado.next());
                                    }catch(Exception e){
                                        genero=Genero.NoModificar;
                                    }
                                    System.out.print("Introduzca el año de publicación del libro [Dejar en blanco para no modificar]: ");
                                    try{
                                        anoPublicacion=Integer.parseInt(teclado.next());
                                    }catch(Exception e){
                                        anoPublicacion = 0;
                                    }
                                    System.out.print("Introduzca la fecha de impresión del libro [Dejar en blanco para no modificar][dd/mm/yyyy]: ");
                                    fechaImpresion=teclado.next();
                                    System.out.print("Introduzca el número de hojas del libro [Dejar en blanco para no modificar]: ");
                                    try{
                                        cantidadHojas=Integer.parseInt(teclado.next());
                                    }catch(Exception e){
                                        cantidadHojas = 0;
                                    }
                                    LPapel.modificarLibro( libros,  titulo,  autor,  anoPublicacion,  ISBN,  genero,  fechaImpresion,  cantidadHojas);
                                    pressAnyKeyToContinue();
                                }
                                if(op4 == 5){
                                    String ISBN;
                                    System.out.print("Introduzca el ISBN del libro a eliminar: ");
                                    ISBN=teclado.next();
                                    LPapel.eliminarLibro(libros, ISBN);
                                    pressAnyKeyToContinue();
                                }
                            }
                        }
                        if(op3 == 2){
                            while(op4 != 0){
                                System.out.println("---- Gestión de Audiolibros ----");
                                System.out.println("1 - Listar Audiolibros");
                                System.out.println("2 - Buscar Audiolibro por ISBN");
                                System.out.println("3 - Añadir Audiolibro");
                                System.out.println("4 - Modificar Audiolibro");
                                System.out.println("5 - Eliminar Audiolibro");
                                System.out.println("0 - Volver Atrás");
                                System.out.print("Introduce una opción: ");
                                op4=Integer.parseInt(teclado.next());
                                if(op4 == 1){
                                    Iterator<Libro> libroIterator = libros.iterator();
                                    while (libroIterator.hasNext()){
                                        Libro libroTemp = libroIterator.next(); // Creamos un objeto temporal del iterador
                                        if(libroTemp instanceof AudioLibro) { // Si el objeto temporal es instancia de CPrivado lo mostramos por pantalla
                                            System.out.println(libroTemp) ; //  así solo listamos los clientes privados
                                        }
                                    }
                                    pressAnyKeyToContinue();
                                }
                                if(op4 == 2){
                                    String ISBN;
                                    System.out.print("Introduzca el ISBN del Audiolibro a buscar: ");
                                    ISBN=teclado.next();
                                    AudioLibro.listarAudioLibroISBN(libros, ISBN);
                                    pressAnyKeyToContinue();
                                }
                                if(op4 == 3){
                                    String titulo, autor, ISBN;
                                    int duracion,anoPublicacion;
                                    Genero genero;

                                    System.out.print("Introduzca el ISBN del Audiolibro: ");
                                    ISBN=teclado.next();
                                    System.out.print("Introduzca el título del Audiolibro: ");
                                    titulo=teclado.next();
                                    System.out.print("Introduzca el autor del Audiolibro: ");
                                    autor=teclado.next();
                                    System.out.print("Introduzca el género del Audiolibro de la siguiente lista\n" +
                                            "- Aventura\n" +
                                            "- Ficcion\n" +
                                            "- Fantasia\n" +
                                            "- Misterio\n" +
                                            "- Romance\n" +
                                            "- Thriller\n" +
                                            "- Terror\n" +
                                            "- Suspense\n" +
                                            "- Comedia\n" +
                                            "- Didactico\n" +
                                            "- Novela\n" +
                                            "Introduzca el género: ");
                                    genero=Genero.valueOf(teclado.next());
                                    System.out.print("Introduzca el año de publicación del Audiolibro: ");
                                    anoPublicacion=Integer.parseInt(teclado.next());
                                    System.out.print("Introduzca la duracion del AudioLibro:  ");
                                    duracion=Integer.parseInt(teclado.next());

                                    try{
                                        libros.add(new AudioLibro(titulo, autor, anoPublicacion, ISBN, genero,duracion));
                                        System.out.println("El AudioLibro se ha añadido ");
                                    } catch (Exception e) {
                                        System.out.println("Error: El AudioLibro no se ha añadido ");
                                    }
                                    pressAnyKeyToContinue();
                                }
                                if(op4 == 4){
                                    String titulo, autor, ISBN;
                                    int duracion,anoPublicacion;
                                    Genero genero;

                                    System.out.print("Introduzca el ISBN del Audiolibro a modificar: ");
                                    ISBN=teclado.next();
                                    System.out.print("Introduzca el Título del Audiolibro [Dejar en blanco para no modificar]: ");
                                    titulo=teclado.next();
                                    System.out.print("Introduzca el autor del Audiolibro [Dejar en blanco para no modificar]: ");
                                    autor=teclado.next();
                                    System.out.print("Introduzca el género del Audiolibro de la siguiente lista [Dejar en blanco para no modificar]\n" +
                                            "- Aventura\n" +
                                            "- Ficcion\n" +
                                            "- Fantasia\n" +
                                            "- Misterio\n" +
                                            "- Romance\n" +
                                            "- Thriller\n" +
                                            "- Terror\n" +
                                            "- Suspense\n" +
                                            "- Comedia\n" +
                                            "- Didactico\n" +
                                            "- Novela\n" +
                                            "Introduzca el género: ");
                                    try{
                                        genero=Genero.valueOf(teclado.next());
                                    }catch(Exception e){
                                        genero=Genero.NoModificar;
                                    }
                                    System.out.print("Introduzca el año de publicación del Audiolibro [Dejar en blanco para no modificar]: ");
                                    try{
                                        anoPublicacion=Integer.parseInt(teclado.next());
                                    }catch(Exception e) {
                                        anoPublicacion = 0;
                                    }
                                    System.out.print("Introduzca la duracion del AudioLibro [Dejar en blanco para no modificar]: ");
                                    try{
                                        duracion=Integer.parseInt(teclado.next());
                                    }catch(Exception e){
                                        duracion = 0;
                                    }
                                    AudioLibro.modificarAudioLibro( libros, titulo, autor, anoPublicacion, ISBN, genero, duracion);
                                    pressAnyKeyToContinue();
                                }
                            }
                        }
                        if(op3 == 3){
                            while(op4 != 0) {
                                System.out.println("---- Gestión de Discos De Vinilo ----");
                                System.out.println("1 - Listar Discos de Vinilo");
                                System.out.println("2 - Buscar Disco de Vinilo por ID");
                                System.out.println("3 - Añadir Disco de Vinilo");
                                System.out.println("4 - Modificar Disco de Vinilo");
                                System.out.println("5 - Eliminar Disco de Vinilo");
                                System.out.println("0 - Volver Atrás");
                                System.out.print("Introduce una opción: ");
                                op4 = Integer.parseInt(teclado.next());

                                if (op4 == 1) {
                                    Iterator<DiscoVinilo> iteratorDiscoVinilo = discosVinilo.iterator();
                                    while (iteratorDiscoVinilo.hasNext()) {
                                        System.out.println(iteratorDiscoVinilo.next());
                                    }
                                    pressAnyKeyToContinue();
                                }
                                if(op4 == 2){
                                    int id;
                                    System.out.print("Introduzca el ID del Disco de Vinilo a buscar: ");
                                    id=Integer.parseInt(teclado.next());
                                    DiscoVinilo.listarDiscoViniloId(discosVinilo, id);
                                    pressAnyKeyToContinue();
                                }
                                if(op4 == 3){
                                    String titulo, autor;
                                    int idDisco, anoPublicacion, numPista, duracionDisco;
                                    System.out.print("Introduzca el Id del Disco: ");
                                    idDisco=Integer.parseInt(teclado.next());
                                    System.out.print("Introduzca el Título del Disco: ");
                                    titulo=teclado.next();
                                    System.out.print("Introduzca el Autor del Disco: ");
                                    autor=teclado.next();
                                    System.out.print("Introduzca el Año de Publicación del Disco: ");
                                    anoPublicacion=Integer.parseInt(teclado.next());
                                    System.out.print("Introduzca el número de pistas totales del Disco: ");
                                    numPista=Integer.parseInt(teclado.next());
                                    System.out.print("Introduzca la Duración del Disco (En minutos): ");
                                    duracionDisco=Integer.parseInt(teclado.next());
                                    try{
                                        discosVinilo.add(new DiscoVinilo(idDisco, titulo, autor, anoPublicacion, numPista, duracionDisco));
                                        System.out.println("Disco añadido");
                                    }catch(Exception e){
                                        System.out.println("Error, No se ha podido añadir el Disco");
                                    }
                                    pressAnyKeyToContinue();
                                }
                                if(op4 == 4){
                                    String titulo, autor;
                                    int idDisco, anoPublicacion, numPista, duracionDisco;
                                    System.out.print("Introduzca el Id del Disco a modificar: ");
                                    idDisco=Integer.parseInt(teclado.next());
                                    System.out.print("Introduzca el Título del Disco [Dejar en blanco para no modificar]: ");
                                    titulo=teclado.next();
                                    System.out.print("Introduzca el Autor del Disco [Dejar en blanco para no modificar]: ");
                                    autor=teclado.next();
                                    System.out.print("Introduzca el Año de Publicación del Disco [Dejar en blanco para no modificar]: ");
                                    try{
                                        anoPublicacion=Integer.parseInt(teclado.next());
                                    }catch(Exception e){
                                        anoPublicacion = 0;
                                    }
                                    System.out.print("Introduzca el número de pistas totales del Disco [Dejar en blanco para no modificar]: ");
                                    try{
                                        numPista = Integer.parseInt(teclado.next());
                                    }catch(Exception e){
                                        numPista = 0;
                                    }
                                    System.out.print("Introduzca la Duración del Disco (En minutos) [Dejar en blanco para no modificar]: ");
                                    try{
                                        duracionDisco = Integer.parseInt(teclado.next());
                                    }catch(Exception e){
                                        duracionDisco = 0;
                                    }
                                    try{
                                        DiscoVinilo.modificarDiscoVinilo(discosVinilo, idDisco, titulo, autor, anoPublicacion, numPista, duracionDisco);
                                        System.out.println("Disco Modificado");
                                    }catch(Exception e){
                                        System.out.println("Error, No se ha podido modificar el Disco");
                                    }
                                    pressAnyKeyToContinue();
                                }
                                if(op4 == 5){
                                    int id;
                                    System.out.print("Introduzca el ID del Disco de Vinilo a eliminar: ");
                                    id=Integer.parseInt(teclado.next());
                                    DiscoVinilo.eliminarDiscoVinilo(discosVinilo, id);
                                    pressAnyKeyToContinue();
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    while (op3 != 0) {
                        op3 = 99; //Reinicia el valor de op3!.
                        System.out.println("---- Gestión de Préstamos ----");
                        System.out.println("1 - Gestion de Prestamos de Libros");
                        System.out.println("2 - Gestion de Prestamos de Libros");
                        System.out.println("3 - Gestion de Prestamos de Discos de Vinilo");
                        System.out.println("0 - Volver Atrás");
                        System.out.print("Introduce una opción: ");
                        op3=Integer.parseInt(teclado.next());
                        op4 = 99; //Reinicia el valor de op4!.
                            if(op3 == 1) {
                                while (op4 != 0){
                                    System.out.println("---- Gestión de Préstamos de Libros ----");
                                    System.out.println("1 - Listar Libros prestados");
                                    System.out.println("2 - Buscar Libro prestado por ISBN");
                                    System.out.println("3 - Prestar Libro");
                                    System.out.println("4 - Devolver Libro");
                                    System.out.println("0 - Volver Atrás");
                                    System.out.print("Introduce una opción: ");
                                    op4=Integer.parseInt(teclado.next());

                                }
                            }
                            if(op3 == 3) {
                                while (op4 != 0) {
                                    System.out.println("---- Gestión de Préstamos de Discos de Vinilo ----");
                                    System.out.println("1 - Listar Discos de Vinilo prestados");
                                    System.out.println("2 - Buscar Disco de Vinilo prestado por ISBN");
                                    System.out.println("3 - Prestar Disco de Vinilo");
                                    System.out.println("4 - Devolver Disco de Vinilo");
                                    System.out.println("0 - Volver Atrás");
                                    System.out.print("Introduce una opción: ");
                                    op4=Integer.parseInt(teclado.next());
                                    if (op4 == 1) {
                                        Iterator<ReservaDV> iteratorReservaDV = reservaDiscosVinilo.iterator();
                                        while (iteratorReservaDV.hasNext()) {
                                            System.out.println(iteratorReservaDV.next());
                                        }
                                        pressAnyKeyToContinue();
                                    }
                                    if (op4 == 3) {
                                        int idDisco;
                                        String idEscuela;
                                        System.out.print("Introdueix el Identificador de la Escola: ");
                                        idEscuela = teclado.next();
                                        System.out.print("Introdueix el Identificador del Disc a prestar: ");
                                        idDisco = teclado.nextInt();
                                        ReservaDV.prestarDiscoVinilo(discosVinilo, clientes, reservaDiscosVinilo, idDisco, idEscuela);
                                    }
                                }
                            }
                        }
                    break;
                case 4:
                    while(op2 != 0){
                        String usuario, password;
                        System.out.print("usuario: ");
                        usuario = teclado.next();
                        System.out.print("contraseña: ");
                        password = teclado.next();
                        if(usuario.equals("admin") && password.equals("admin")) {
                            System.out.println("---- Gestión de Trabajadores ----");
                            System.out.println("1 - Listar Trabajadores");
                            System.out.println("2 - Buscar Trabajador por DNI");
                            System.out.println("3 - Añadir Trabajador");
                            System.out.println("4 - Modificar Trabajador");
                            System.out.println("5 - Eliminar Trabajador");
                            System.out.println("0 - Volver Atrás");
                            System.out.print("Introduce una opción: ");
                            op2 = Integer.parseInt(teclado.next());
                            if(op2 == 1){
                                Iterator<Treballador> iteratorTrabajadores = trabajadores.iterator();
                                while (iteratorTrabajadores.hasNext()) {
                                    System.out.println(iteratorTrabajadores.next());
                                }
                                pressAnyKeyToContinue();
                            }
                            if(op2 == 2){
                                String nif;
                                System.out.print("Introduzca el DNI del Empleado a buscar: ");
                                nif=teclado.next();
                                Treballador.listarTrabajadorNIF(trabajadores, nif);
                                pressAnyKeyToContinue();
                            }
                        }else{
                            System.out.println("Usuario y/o contraseña incorrectos");
                            pressAnyKeyToContinue();
                            op2 = 0;
                        }
                    }
                    break;
            }
        } while (op1!=0);
    }

}

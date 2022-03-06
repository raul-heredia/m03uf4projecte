package edu.fje.m03uf4projecte;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class CargarXML {
    public static ArrayList cargarClientes(){
        //creem un fitxer normal per carregar les dades del XML, sino està a la carpeta posar ruta
        File file = new File("clientes.xml");
        ArrayList<Cliente> clientes = new ArrayList<>();
        //llista de nodes que ens fara falta més endavant
        NodeList nList = null;

        try {

            //intentem fer el parse a document DOM, sempre es fa amb aquests tres passos
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            //ens posicionem a l'element arrel i normalitzem el document per si hi ha nodes buits
            doc.getDocumentElement().normalize();

            //guardem a la llista de nodes els elements cotxe
            nList = doc.getElementsByTagName("Cliente");

        } catch(Exception e) {

            e.printStackTrace();

        }

        //recorrem els nodes de la llista de nodes
        for(int i = 0; i < nList.getLength(); i++) {

            //ens posem al primer node
            Node nNode = nList.item(i);

            //comprovem si el node és un node tipus ELEMENT_NODE
            if(nNode.getNodeType() == Node.ELEMENT_NODE) {

                //fem un parse de node a element
                Element eElement = (Element) nNode;


                String tipo = eElement.getElementsByTagName("Tipo").item(0).getTextContent();
                String nombre = eElement.getElementsByTagName("Nombre").item(0).getTextContent();
                String correo = eElement.getElementsByTagName("Correo").item(0).getTextContent();
                String direccion = eElement.getElementsByTagName("Direccion").item(0).getTextContent();
                String identificador = eElement.getElementsByTagName("Identificador").item(0).getTextContent();
                int carnet = Integer.parseInt(eElement.getElementsByTagName("Carnet").item(0).getTextContent());
                if(tipo.equals("CPrivado")){
                    clientes.add(new CPrivado(nombre, correo, direccion, identificador, carnet));
                }else if (tipo.equals("CMusica")){
                    clientes.add(new CMusica(nombre, correo, direccion, identificador, carnet));

                }
            }
        }
        return clientes;
    }
    public static ArrayList cargarLibros(){
        //creem un fitxer normal per carregar les dades del XML, sino està a la carpeta posar ruta
        File file = new File("libros.xml");
        ArrayList<Libro> libros = new ArrayList<>();
        //llista de nodes que ens fara falta més endavant
        NodeList nList = null;

        try {

            //intentem fer el parse a document DOM, sempre es fa amb aquests tres passos
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            //ens posicionem a l'element arrel i normalitzem el document per si hi ha nodes buits
            doc.getDocumentElement().normalize();

            //guardem a la llista de nodes els elements cotxe
            nList = doc.getElementsByTagName("Libro");

        } catch(Exception e) {

            e.printStackTrace();

        }

        //recorrem els nodes de la llista de nodes
        for(int i = 0; i < nList.getLength(); i++) {

            //ens posem al primer node
            Node nNode = nList.item(i);

            //comprovem si el node és un node tipus ELEMENT_NODE
            if(nNode.getNodeType() == Node.ELEMENT_NODE) {

                //fem un parse de node a element
                Element eElement = (Element) nNode;


                String tipo = eElement.getElementsByTagName("Tipo").item(0).getTextContent();
                String nombre = eElement.getElementsByTagName("Nombre").item(0).getTextContent();
                String autor = eElement.getElementsByTagName("Autor").item(0).getTextContent();
                int anyPublicacion = Integer.parseInt(eElement.getElementsByTagName("AnyPublicacion").item(0).getTextContent());
                String isbn = eElement.getElementsByTagName("ISBN").item(0).getTextContent();
                Genero genero = Genero.valueOf(eElement.getElementsByTagName("Genero").item(0).getTextContent());

                if(tipo.equals("LPapel")){
                    String fechaImpresion = eElement.getElementsByTagName("FechaImpresion").item(0).getTextContent();
                    int numeroPaginas = Integer.parseInt(eElement.getElementsByTagName("NumeroPaginas").item(0).getTextContent());
                    libros.add(new LPapel( nombre, autor, anyPublicacion, isbn, genero,fechaImpresion, numeroPaginas));
                }else if (tipo.equals("AudioLibro")){
                    int duracion = Integer.parseInt(eElement.getElementsByTagName("Duracion").item(0).getTextContent());
                    libros.add(new AudioLibro(nombre, autor, anyPublicacion, isbn,genero,duracion));
                }
            }
        }
        return libros;
    }
    public static ArrayList cargarVinilos(){
        //creem un fitxer normal per carregar les dades del XML, sino està a la carpeta posar ruta
        File file = new File("discosVinilo.xml");
        ArrayList<DiscoVinilo> discosVinilo = new ArrayList<>();
        //llista de nodes que ens fara falta més endavant
        NodeList nList = null;

        try {

            //intentem fer el parse a document DOM, sempre es fa amb aquests tres passos
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            //ens posicionem a l'element arrel i normalitzem el document per si hi ha nodes buits
            doc.getDocumentElement().normalize();

            //guardem a la llista de nodes els elements cotxe
            nList = doc.getElementsByTagName("Disco");

        } catch(Exception e) {

            e.printStackTrace();

        }

        //recorrem els nodes de la llista de nodes
        for(int i = 0; i < nList.getLength(); i++) {

            //ens posem al primer node
            Node nNode = nList.item(i);

            //comprovem si el node és un node tipus ELEMENT_NODE
            if(nNode.getNodeType() == Node.ELEMENT_NODE) {

                //fem un parse de node a element
                Element eElement = (Element) nNode;

                int identificadorDisco = Integer.parseInt(eElement.getElementsByTagName("IdentificadorDisco").item(0).getTextContent());
                String nombre = eElement.getElementsByTagName("Nombre").item(0).getTextContent();
                String autor = eElement.getElementsByTagName("Autor").item(0).getTextContent();
                int anyPublicacion = Integer.parseInt(eElement.getElementsByTagName("AnyPublicacion").item(0).getTextContent());
                int numeroPistas = Integer.parseInt(eElement.getElementsByTagName("NumeroPistas").item(0).getTextContent());
                int duracion = Integer.parseInt(eElement.getElementsByTagName("Duracion").item(0).getTextContent());
                discosVinilo.add(new DiscoVinilo(identificadorDisco,nombre, autor, anyPublicacion, numeroPistas, duracion));
            }
        }
        return discosVinilo;
    }
    public static LinkedList<Treballador> cargarTrabajadores(ArrayList clientes, ArrayList discosVinilo, ArrayList libros){
        //creem un fitxer normal per carregar les dades del XML, sino està a la carpeta posar ruta
        File file = new File("trabajadores.xml");
        LinkedList<Treballador> treballadors = new LinkedList<>();
        //llista de nodes que ens fara falta més endavant
        NodeList nList = null;

        try {

            //intentem fer el parse a document DOM, sempre es fa amb aquests tres passos
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            //ens posicionem a l'element arrel i normalitzem el document per si hi ha nodes buits
            doc.getDocumentElement().normalize();

            //guardem a la llista de nodes els elements cotxe
            nList = doc.getElementsByTagName("Trabajador");

        } catch(Exception e) {

            e.printStackTrace();

        }

        //recorrem els nodes de la llista de nodes
        for(int i = 0; i < nList.getLength(); i++) {

            //ens posem al primer node
            Node nNode = nList.item(i);

            //comprovem si el node és un node tipus ELEMENT_NODE
            if(nNode.getNodeType() == Node.ELEMENT_NODE) {

                //fem un parse de node a element
                Element eElement = (Element) nNode;

                String identificador = eElement.getElementsByTagName("Identificador").item(0).getTextContent();
                String nombre = eElement.getElementsByTagName("Nombre").item(0).getTextContent();
                boolean isAdmin = Boolean.parseBoolean(eElement.getElementsByTagName("isAdmin").item(0).getTextContent());
                float salari = Float.parseFloat(eElement.getElementsByTagName("Salario").item(0).getTextContent());

                treballadors.add(new Treballador(identificador,nombre,isAdmin, salari, clientes, libros, discosVinilo));
            }
        }
        return treballadors;
    }
    public static ArrayList<ReservaL> cargarReservasLibros(){
        //creem un fitxer normal per carregar les dades del XML, sino està a la carpeta posar ruta
        File file = new File("reservasLibros.xml");
        ArrayList<ReservaL> reservaLS = new ArrayList<>();
        //llista de nodes que ens fara falta més endavant
        NodeList nList = null;

        try {

            //intentem fer el parse a document DOM, sempre es fa amb aquests tres passos
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            //ens posicionem a l'element arrel i normalitzem el document per si hi ha nodes buits
            doc.getDocumentElement().normalize();

            //guardem a la llista de nodes els elements cotxe
            nList = doc.getElementsByTagName("Reserva");

        } catch(Exception e) {

            e.printStackTrace();

        }

        //recorrem els nodes de la llista de nodes
        for(int i = 0; i < nList.getLength(); i++) {

            //ens posem al primer node
            Node nNode = nList.item(i);

            //comprovem si el node és un node tipus ELEMENT_NODE
            if(nNode.getNodeType() == Node.ELEMENT_NODE) {

                //fem un parse de node a element
                Element eElement = (Element) nNode;

                String nif = eElement.getElementsByTagName("IdentificadorCliente").item(0).getTextContent();
                String isbn = eElement.getElementsByTagName("ISBN").item(0).getTextContent();

                reservaLS.add(new ReservaL(nif,isbn));
            }
        }
        return reservaLS;
    }
    public static ArrayList<ReservaDV> cargarReservasVinilo(){
        //creem un fitxer normal per carregar les dades del XML, sino està a la carpeta posar ruta
        File file = new File("reservasDiscoVinilo.xml");
        ArrayList<ReservaDV> reservaDVS = new ArrayList<>();
        //llista de nodes que ens fara falta més endavant
        NodeList nList = null;

        try {

            //intentem fer el parse a document DOM, sempre es fa amb aquests tres passos
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            //ens posicionem a l'element arrel i normalitzem el document per si hi ha nodes buits
            doc.getDocumentElement().normalize();

            //guardem a la llista de nodes els elements cotxe
            nList = doc.getElementsByTagName("Reserva");

        } catch(Exception e) {

            e.printStackTrace();

        }

        //recorrem els nodes de la llista de nodes
        for(int i = 0; i < nList.getLength(); i++) {

            //ens posem al primer node
            Node nNode = nList.item(i);

            //comprovem si el node és un node tipus ELEMENT_NODE
            if(nNode.getNodeType() == Node.ELEMENT_NODE) {

                //fem un parse de node a element
                Element eElement = (Element) nNode;

                int idDisco = Integer.parseInt(eElement.getElementsByTagName("IdentificadorDisco").item(0).getTextContent());
                String idEscuela = eElement.getElementsByTagName("IdentificadorEscuela").item(0).getTextContent();

                reservaDVS.add(new ReservaDV(idDisco,idEscuela));
            }
        }
        return reservaDVS;
    }
}

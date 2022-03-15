package edu.fje.m03uf4projecte;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class GuardarXML {
    public static void guardarClientes(ArrayList clientes){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Elemento raíz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Clientes");
            doc.appendChild(rootElement);

            //Primer elemento


            for (int i = 0; i < clientes.size(); i++) {
                // Creamos elemeto cliente y lo añadimos al root element
                Element cliente = doc.createElement("Cliente");
                rootElement.appendChild(cliente);
                if(clientes.get(i) instanceof CPrivado){
                    // Creamos elemento Tipo
                    Element tipo = doc.createElement("Tipo");
                    tipo.appendChild(doc.createTextNode(String.valueOf("CPrivado")));
                    cliente.appendChild(tipo);
                    // Creamos elemento Nombre
                    Element nombre = doc.createElement("Nombre");
                    nombre.appendChild(doc.createTextNode(String.valueOf(((CPrivado) clientes.get(i)).getNombre())));
                    cliente.appendChild(nombre);
                    // Creamos elemento Correo
                    Element correo = doc.createElement("Correo");
                    correo.appendChild(doc.createTextNode(String.valueOf(((CPrivado) clientes.get(i)).getEmail())));
                    cliente.appendChild(correo);
                    // Creamos elemento Direccion
                    Element direccion = doc.createElement("Direccion");
                    direccion.appendChild(doc.createTextNode(String.valueOf(((CPrivado) clientes.get(i)).getDireccion())));
                    cliente.appendChild(direccion);
                    // Creamos elemento Identificador
                    Element identificador = doc.createElement("Identificador");
                    identificador.appendChild(doc.createTextNode(String.valueOf(((CPrivado) clientes.get(i)).getNif())));
                    cliente.appendChild(identificador);
                    // Creamos elemento Carnet
                    Element carnet = doc.createElement("Carnet");
                    carnet.appendChild(doc.createTextNode(String.valueOf(((CPrivado) clientes.get(i)).getCarnet())));
                    cliente.appendChild(carnet);
                }else if(clientes.get(i) instanceof CMusica){
                    // Creamos elemento Tipo
                    Element tipo = doc.createElement("Tipo");
                    tipo.appendChild(doc.createTextNode(String.valueOf("CMusica")));
                    cliente.appendChild(tipo);
                    // Creamos elemento Nombre
                    Element nombre = doc.createElement("Nombre");
                    nombre.appendChild(doc.createTextNode(String.valueOf(((CMusica) clientes.get(i)).getNombre())));
                    cliente.appendChild(nombre);
                    // Creamos elemento Correo
                    Element correo = doc.createElement("Correo");
                    correo.appendChild(doc.createTextNode(String.valueOf(((CMusica) clientes.get(i)).getEmail())));
                    cliente.appendChild(correo);
                    // Creamos elemento Direccion
                    Element direccion = doc.createElement("Direccion");
                    direccion.appendChild(doc.createTextNode(String.valueOf(((CMusica) clientes.get(i)).getDireccion())));
                    cliente.appendChild(direccion);
                    // Creamos elemento Identificador
                    Element identificador = doc.createElement("Identificador");
                    identificador.appendChild(doc.createTextNode(String.valueOf(((CMusica) clientes.get(i)).getIdEscola())));
                    cliente.appendChild(identificador);
                    // Creamos elemento Carnet
                    Element carnet = doc.createElement("Carnet");
                    carnet.appendChild(doc.createTextNode(String.valueOf(((CMusica) clientes.get(i)).getCarnet())));
                    cliente.appendChild(carnet);
                }
            }
            //Se escribe el contenido del XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("clientes.xml"));
            transformer.transform(source, result);
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
    public static void guardarLibros(ArrayList libros){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Elemento raíz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Libros");
            doc.appendChild(rootElement);

            //Primer elemento


            for (int i = 0; i < libros.size(); i++) {
                // Creamos elemeto cliente y lo añadimos al root element
                Element libro = doc.createElement("Libro");
                rootElement.appendChild(libro);
                if(libros.get(i) instanceof LPapel){
                    // Creamos elemento Tipo
                    Element tipo = doc.createElement("Tipo");
                    tipo.appendChild(doc.createTextNode(String.valueOf("LPapel")));
                    libro.appendChild(tipo);
                    // Creamos elemento Nombre
                    Element nombre = doc.createElement("Nombre");
                    nombre.appendChild(doc.createTextNode(String.valueOf(((LPapel) libros.get(i)).getTitulo())));
                    libro.appendChild(nombre);
                    // Creamos elemento Autor
                    Element autor = doc.createElement("Autor");
                    autor.appendChild(doc.createTextNode(String.valueOf(((LPapel) libros.get(i)).getAutor())));
                    libro.appendChild(autor);
                    // Creamos elemento Año publicacion
                    Element anypublicacion = doc.createElement("AnyPublicacion");
                    anypublicacion.appendChild(doc.createTextNode(String.valueOf(((LPapel) libros.get(i)).getAnoPublicacion())));
                    libro.appendChild(anypublicacion);
                    // Creamos elemento isbn
                    Element isbn = doc.createElement("ISBN");
                    isbn.appendChild(doc.createTextNode(String.valueOf(((LPapel) libros.get(i)).getISBN())));
                    libro.appendChild(isbn);
                    // Creamos elemento Genero
                    Element genero = doc.createElement("Genero");
                    genero.appendChild(doc.createTextNode(String.valueOf(((LPapel) libros.get(i)).getGenero())));
                    libro.appendChild(genero);
                    // Creamos elemento Fecha Impresion
                    Element fechaImpresion = doc.createElement("FechaImpresion");
                    fechaImpresion.appendChild(doc.createTextNode(String.valueOf(((LPapel) libros.get(i)).getFechaImpresion())));
                    libro.appendChild(fechaImpresion);                    // Creamos elemento NumeroPaginas
                    Element numeroPaginas = doc.createElement("NumeroPaginas");
                    numeroPaginas.appendChild(doc.createTextNode(String.valueOf(((LPapel) libros.get(i)).getCantidadHojas())));
                    libro.appendChild(numeroPaginas);
                }else if(libros.get(i) instanceof AudioLibro){
                    // Creamos elemento Tipo
                    Element tipo = doc.createElement("Tipo");
                    tipo.appendChild(doc.createTextNode(String.valueOf("AudioLibro")));
                    libro.appendChild(tipo);
                    // Creamos elemento Nombre
                    Element nombre = doc.createElement("Nombre");
                    nombre.appendChild(doc.createTextNode(String.valueOf(((AudioLibro) libros.get(i)).getTitulo())));
                    libro.appendChild(nombre);
                    // Creamos elemento Autor
                    Element autor = doc.createElement("Autor");
                    autor.appendChild(doc.createTextNode(String.valueOf(((AudioLibro) libros.get(i)).getAutor())));
                    libro.appendChild(autor);
                    // Creamos elemento Año publicacion
                    Element anypublicacion = doc.createElement("AnyPublicacion");
                    anypublicacion.appendChild(doc.createTextNode(String.valueOf(((AudioLibro) libros.get(i)).getAnoPublicacion())));
                    libro.appendChild(anypublicacion);
                    // Creamos elemento isbn
                    Element isbn = doc.createElement("ISBN");
                    isbn.appendChild(doc.createTextNode(String.valueOf(((AudioLibro) libros.get(i)).getISBN())));
                    libro.appendChild(isbn);
                    // Creamos elemento Genero
                    Element genero = doc.createElement("Genero");
                    genero.appendChild(doc.createTextNode(String.valueOf(((AudioLibro) libros.get(i)).getGenero())));
                    libro.appendChild(genero);
                    // Creamos elemento Fecha Impresion
                    Element duracion = doc.createElement("Duracion");
                    duracion.appendChild(doc.createTextNode(String.valueOf(((AudioLibro) libros.get(i)).getDuracion())));
                    libro.appendChild(duracion);
                }
            }
            //Se escribe el contenido del XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("libros.xml"));
            transformer.transform(source, result);
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
    public static void guardarDiscosVinilo(ArrayList discosVinilo){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Elemento raíz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Discos");
            doc.appendChild(rootElement);

            //Primer elemento


            for (int i = 0; i < discosVinilo.size(); i++) {
                // Creamos elemeto cliente y lo añadimos al root element
                Element disco = doc.createElement("Disco");
                rootElement.appendChild(disco);
                // Creamos elemento Tipo
                Element identificadorDisco = doc.createElement("IdentificadorDisco");
                identificadorDisco.appendChild(doc.createTextNode(String.valueOf(((DiscoVinilo) discosVinilo.get(i)).getIdDisco())));
                disco.appendChild(identificadorDisco);
                // Creamos elemento Nombre
                Element nombre = doc.createElement("Nombre");
                nombre.appendChild(doc.createTextNode(String.valueOf(((DiscoVinilo) discosVinilo.get(i)).getTitulo())));
                disco.appendChild(nombre);
                // Creamos elemento Autor
                Element autor = doc.createElement("Autor");
                autor.appendChild(doc.createTextNode(String.valueOf(((DiscoVinilo) discosVinilo.get(i)).getAutor())));
                disco.appendChild(autor);
                // Creamos elemento Año publicacion
                Element anypublicacion = doc.createElement("AnyPublicacion");
                anypublicacion.appendChild(doc.createTextNode(String.valueOf(((DiscoVinilo) discosVinilo.get(i)).getAnoPublicacion())));
                disco.appendChild(anypublicacion);
                // Creamos elemento isbn
                Element numeroPistas = doc.createElement("NumeroPistas");
                numeroPistas.appendChild(doc.createTextNode(String.valueOf(((DiscoVinilo) discosVinilo.get(i)).getNumPista())));
                disco.appendChild(numeroPistas);
                // Creamos elemento Fecha Impresion
                Element duracion = doc.createElement("Duracion");
                duracion.appendChild(doc.createTextNode(String.valueOf(((DiscoVinilo) discosVinilo.get(i)).getDuracionDisco())));
                disco.appendChild(duracion);

            }
            //Se escribe el contenido del XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("discosVinilo.xml"));
            transformer.transform(source, result);
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}

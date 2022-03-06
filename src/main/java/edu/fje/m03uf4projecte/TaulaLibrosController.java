package edu.fje.m03uf4projecte;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class TaulaLibrosController implements Initializable {

    @FXML
    private TableView<TaulaLibrosProperties> taula;

    @FXML
    private Button boto;

    @FXML
    protected void carregar(ActionEvent event) {
        taula.getItems().clear();
        ObservableList<TaulaLibrosProperties> dades = taula.getItems();
        carregarXML(dades);
    }
    @FXML
    protected void carregarPrimer() {
        ObservableList<TaulaLibrosProperties> dades = taula.getItems();
        carregarXML(dades);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarPrimer();
    }

    private void carregarXML(ObservableList<TaulaLibrosProperties> dades) {
        try {
            File discos = new File("libros.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(discos);
            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("Libro");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    if (obtenirContingut("Tipo", element).equals("LPapel")){
                        dades.add(new TaulaLibrosProperties(
                                obtenirContingut("Tipo", element),
                                obtenirContingut("Nombre", element),
                                obtenirContingut("Autor", element),
                                Integer.parseInt(obtenirContingut("AnyPublicacion", element)),
                                obtenirContingut("ISBN", element),
                                obtenirContingut("Genero", element),
                                obtenirContingut("FechaImpresion", element),
                                Integer.parseInt(obtenirContingut("NumeroPaginas", element))));
                    }else if(obtenirContingut("Tipo", element).equals("AudioLibro")){
                        dades.add(new TaulaLibrosProperties(
                                obtenirContingut("Tipo", element),
                                obtenirContingut("Nombre", element),
                                obtenirContingut("Autor", element),
                                Integer.parseInt(obtenirContingut("AnyPublicacion", element)),
                                obtenirContingut("ISBN", element),
                                obtenirContingut("Genero", element),
                                Integer.parseInt(obtenirContingut("Duracion", element))));
                    }



                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String obtenirContingut(String etiqueta, Element element) {
        NodeList nodes = element.getElementsByTagName(etiqueta).item(0)
                    .getChildNodes();
            Node node = (Node) nodes.item(0);
            return node.getNodeValue();
    }
}

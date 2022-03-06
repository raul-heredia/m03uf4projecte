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

/**
 * FXML Controller class
 *
 * @author sergi grau
 * @version 1.0 15/01/2015
 */
public class TaulaDiscosController implements Initializable {

	@FXML
	private TableView<TaulaDiscosProperties> taula;

	@FXML
	private Button boto;

	@FXML
	protected void carregar(ActionEvent event) {
		taula.getItems().clear();
		ObservableList<TaulaDiscosProperties> dades = taula.getItems();
		carregarXML(dades);
	}
	@FXML
	protected void carregarPrimer() {
		ObservableList<TaulaDiscosProperties> dades = taula.getItems();
		carregarXML(dades);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarPrimer();
	}

	private void carregarXML(ObservableList<TaulaDiscosProperties> dades) {
		try {
			File discos = new File("discosVinilo.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(discos);
			doc.getDocumentElement().normalize();

			NodeList nodes = doc.getElementsByTagName("Disco");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					dades.add(new TaulaDiscosProperties(
							Integer.parseInt(obtenirContingut("IdentificadorDisco", element)),
							obtenirContingut("Nombre", element),
							obtenirContingut("Autor", element),
							Integer.parseInt(obtenirContingut("AnyPublicacion", element)),
							Integer.parseInt(obtenirContingut("NumeroPistas", element)),
							Integer.parseInt(obtenirContingut("Duracion", element))));

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

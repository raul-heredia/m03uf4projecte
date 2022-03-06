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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author sergi grau
 * @version 1.0 15/01/2015
 */
public class TaulaClientsController implements Initializable {

	@FXML
	private TableView<TaulaClientsProperties> taula;

	@FXML
	private Button boto;

	@FXML
	protected void carregar(ActionEvent event) {
		taula.getItems().clear();
		ObservableList<TaulaClientsProperties> dades = taula.getItems();
		carregarXML(dades);
	}
	@FXML
	protected void carregarPrimer() {
		ObservableList<TaulaClientsProperties> dades = taula.getItems();
		carregarXML(dades);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarPrimer();
	}

	private void carregarXML(ObservableList<TaulaClientsProperties> dades) {
		try {
			File stocks = new File("clientes.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stocks);
			doc.getDocumentElement().normalize();

			NodeList nodes = doc.getElementsByTagName("Cliente");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					dades.add(new TaulaClientsProperties(
							obtenirContingut("Tipo", element),
							obtenirContingut("Nombre", element),
							obtenirContingut("Correo", element),
							obtenirContingut("Direccion", element),
							obtenirContingut("Identificador", element)));

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

	public void exportarClientes() throws Exception {
		Writer writer = null;
		try {
			File file = new File("clientes.csv");
			writer = new BufferedWriter(new FileWriter(file));
			for (TaulaClientsProperties client : taula.getItems()) {

				String text = client.getTipo() + "," + client.getIdentificador() + "," + client.getNombre() + "," + client.getDireccion() + "," + client.getCorreo() + "\n";
				writer.write(text);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			writer.flush();
			writer.close();
		}
	}

}

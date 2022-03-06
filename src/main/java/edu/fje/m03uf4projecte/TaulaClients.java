
package edu.fje.m03uf4projecte;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Classe que carrega les dades d'un fitxer XML en unes
 * classes TableView i TableColumn
 *  amb JavaFX
 * @author sergi grau
 * @version 1.0 19.01.2015
 */
public class TaulaClients extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(BibliotecaApplication.class.getResource("TaulaClients.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 260);
        stage.setTitle("Clients");
        stage.setScene(scene);
        stage.show();
    }
}


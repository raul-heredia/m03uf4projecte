package edu.fje.m03uf4projecte;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase para crear la Aplicacion de JavaFX de la libreria
 */
public class BibliotecaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BibliotecaApplication.class.getResource("biblioteca-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Funcion para JavaFX
     * @param args argumentos de la funcion
     */
    public static void main(String[] args) {
        launch();
    }
}
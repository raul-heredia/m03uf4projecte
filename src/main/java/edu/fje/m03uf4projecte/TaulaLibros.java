package edu.fje.m03uf4projecte;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TaulaLibros extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(BibliotecaApplication.class.getResource("TaulaLibros.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 320);
        stage.setTitle("Libros");
        stage.setScene(scene);
        stage.show();
    }
}

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
        FXMLLoader fxmlLoader = new FXMLLoader(BibliotecaApplication.class.getResource("libros.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 780, 220);
        stage.setTitle("Libros");
        stage.setScene(scene);
        stage.show();
    }
}

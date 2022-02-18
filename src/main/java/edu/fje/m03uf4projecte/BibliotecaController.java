package edu.fje.m03uf4projecte;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

    /**
     * Clase controladora de JAVA FX
     */
public class BibliotecaController {
    /**
     * Propiedad Label con el texto de Bienvenida
     */
    @FXML
    private Label welcomeText;
    /**
     * Funcion que da el Welcome text al clicar en el boton
     */
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
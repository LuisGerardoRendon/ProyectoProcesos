/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class VistaResgistroController implements Initializable {

    @FXML
    private Label labelNombre;
    @FXML
    private Label labelCorreo;
    @FXML
    private Label labelEdad;
    @FXML
    private Label labelTelefono;
    @FXML
    private Label labelNacionalidad;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textfieldCorreo;
    @FXML
    private TextField textfieldEdad;
    @FXML
    private TextField textfieldTelefono;
    @FXML
    private TextField textfieldNacionalidad;
    @FXML
    private Button botonCancelar;
    @FXML
    private Button botonAceptar;
    @FXML
    private Label labelRegistrarse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancelar(ActionEvent event) {
    }

    @FXML
    private void aceptar(ActionEvent event) {
    }
    
}

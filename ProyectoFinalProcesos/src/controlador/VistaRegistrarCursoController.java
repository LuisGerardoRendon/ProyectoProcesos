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
public class VistaRegistrarCursoController implements Initializable {

    @FXML
    private Label labelNombre;
    @FXML
    private Label labelCupo;
    @FXML
    private Label labelCreditos;
    @FXML
    private Label labelFechaInicio;
    @FXML
    private Label labelFechaFin;
    @FXML
    private TextField textfieldNombre;
    @FXML
    private TextField textfieldCupo;
    @FXML
    private TextField textfieldCreditos;
    @FXML
    private TextField textfieldFechaInicio;
    @FXML
    private TextField textfieldFechaFin;
    @FXML
    private Button botonRegistrar;
    @FXML
    private Button botonCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registrar(ActionEvent event) {
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }
    
}

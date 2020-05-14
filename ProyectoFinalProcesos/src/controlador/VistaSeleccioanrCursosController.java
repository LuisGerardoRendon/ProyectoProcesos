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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class VistaSeleccioanrCursosController implements Initializable {

    @FXML
    private TableView<?> tablaCursosDisponibles;
    @FXML
    private TableColumn<?, ?> columnaNRCDisponibles;
    @FXML
    private TableColumn<?, ?> columnaNombreDisponibles;
    @FXML
    private Label labeLlniciar;
    @FXML
    private TableView<?> tablaCursosSeleccionados;
    @FXML
    private TableColumn<?, ?> columnaNrcSeleccionados;
    @FXML
    private TableColumn<?, ?> columanNombreSeleccionados;
    @FXML
    private Label labelSeleccionados;
    @FXML
    private Button botonSeleccionar;
    @FXML
    private Button botonInscribir;
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
    private void seleccionar(ActionEvent event) {
    }

    @FXML
    private void inscribir(ActionEvent event) {
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }
    
}

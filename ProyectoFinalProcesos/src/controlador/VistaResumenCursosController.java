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
public class VistaResumenCursosController implements Initializable {

    @FXML
    private TableView<?> tablaCursosSeleccionados;
    @FXML
    private TableColumn<?, ?> columnaNRCSeleccionados;
    @FXML
    private TableColumn<?, ?> columnaCursosSeleccionados;
    @FXML
    private Label labelMontoTotal;
    @FXML
    private Label labelSetMontoTotal;
    @FXML
    private Button botonCancelar;
    @FXML
    private Button botonAceptar;

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

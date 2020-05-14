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
public class VistaInformacionDelCursoController implements Initializable {

    @FXML
    private Label nrcLabel;
    @FXML
    private Label nombreLabel;
    @FXML
    private Label cupoLabel;
    @FXML
    private Label creditosLabel;
    @FXML
    private Label fechaInicioLabel;
    @FXML
    private Label fechaFinLabel;
    @FXML
    private Label setNrcLabel;
    @FXML
    private Label setNombreLabel;
    @FXML
    private Label setCupoLabel;
    @FXML
    private Label setCreditosLabel;
    @FXML
    private Label setFechaInicioLabel;
    @FXML
    private Label setFechaFinLanel;
    @FXML
    private TableView<?> tablaClientes;
    @FXML
    private TableColumn<?, ?> columnaClientes;
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
    private void aceptar(ActionEvent event) {
    }
    
}

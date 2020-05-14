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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class VistaMostrarCursosController implements Initializable {

    @FXML
    private Label labelMostrarCursos;
    @FXML
    private RadioButton radioBotonTodos;
    @FXML
    private RadioButton radioBotonDisponibles;
    @FXML
    private RadioButton radioBotonCursando;
    @FXML
    private RadioButton radioBotonConcluido;
    @FXML
    private TableView<?> tablaCursos;
    @FXML
    private TableColumn<?, ?> comlumnaCursos;
    @FXML
    private Button botonInformacionCurso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void informacionCurso(ActionEvent event) {
    }
    
}

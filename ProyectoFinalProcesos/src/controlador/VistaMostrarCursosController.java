/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Alertas;
import modelo.CursoVO;
import modelo.Curso_DAO_Implements;

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
    private TableView<CursoVO> tablaCursos;
    @FXML
    private TableColumn<?, ?> comlumnaCursos;
    @FXML
    private Button botonInformacionCurso;
    @FXML
    private Button botonRegistrarCurso;

    ObservableList<CursoVO> cursos = FXCollections.observableArrayList();
    Curso_DAO_Implements curso_DAO = new Curso_DAO_Implements();
    Alertas alerta = new Alertas();
    
    @FXML
    private Button botonMostrarCursos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg = new ToggleGroup();
        radioBotonConcluido.setToggleGroup(tg);
        radioBotonCursando.setToggleGroup(tg);
        radioBotonDisponibles.setToggleGroup(tg);
        radioBotonTodos.setToggleGroup(tg);

    }

    public void inicializarTabla(String filtro) {
        //this.columnaClave.setCellValueFactory(new PropertyValueFactory("clave"));
        this.comlumnaCursos.setCellValueFactory(new PropertyValueFactory("nombre"));
        cursos = curso_DAO.recuperarCursos(filtro);
        tablaCursos.setItems(cursos);
    }

    @FXML
    private void informacionCurso(ActionEvent event) {
        mostrarVistaInformacionCurso();
    }

    @FXML
    private void registrarCurso(ActionEvent event) {
        mostrarVentanaRegistrarCurso();
    }

    public void mostrarVentanaRegistrarCurso() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaRegistrarCurso.fxml"));
            Parent root = loader.load();
            VistaRegistrarCursoController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            Stage stage1 = (Stage) this.botonRegistrarCurso.getScene().getWindow();

        } catch (IOException e) {
        }
    }

    @FXML
    private void mostrarCursos(ActionEvent event) {
        String filtro = "Todos";

        if (radioBotonConcluido.isSelected()) {
            filtro = "Concluido";
            //inicializarTabla("Concluido");
        } else if (radioBotonCursando.isSelected()) {
            filtro = "Cursando";
            //inicializarTabla("Cursando");
        } else if (radioBotonDisponibles.isSelected()) {
            filtro = "Disponible";
            //inicializarTabla("Disponible");
        } else if (radioBotonTodos.isSelected()) {
            filtro = "Todos";
            //inicializarTabla("Todos");
        }
        inicializarTabla(filtro);

    }

    public void mostrarVistaInformacionCurso() {
        CursoVO curso = tablaCursos.getSelectionModel().getSelectedItem();

        if (curso != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaInformacionDelCurso.fxml"));
                Parent root = loader.load();
                VistaInformacionDelCursoController controlador = loader.getController();
                controlador.initDatos(cursos, curso);
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();
                //Stage stage1 = (Stage) this.botonRegistrarCurso.getScene().getWindow();

            } catch (IOException e) {

            }

        }else{
            alerta.alertaInformacion("Por favor, selecciona un curso");
            
        }

    }

}

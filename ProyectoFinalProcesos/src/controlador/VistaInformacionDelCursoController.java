/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import modelo.CursoVO;

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
    
    private CursoVO curso;
    private ObservableList<CursoVO> cursosEnTabla;
    @FXML
    private Label labelCategoria;
    @FXML
    private Label setCategoriaLabel;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //llenarDatos();
    }    

    @FXML
    private void aceptar(ActionEvent event) {
        Stage stage = (Stage) this.botonAceptar.getScene().getWindow();
        stage.close();
    }
    
    public void initDatos(ObservableList<CursoVO> cursos, CursoVO curso ){
        this.cursosEnTabla = cursos;
        this.curso = curso;
        llenarDatos();
    }
    
    public void llenarDatos(){
        this.setCreditosLabel.setText(curso.getCreditos()+"");
        this.setNrcLabel.setText(curso.getNrc());
        this.setCupoLabel.setText(curso.getCupo()+"");
        this.setFechaFinLanel.setText(formatoFecha (curso.getFechaFin().toString()));
        this.setFechaInicioLabel.setText(formatoFecha(curso.getFechaInicio().toString()));
        this.setNombreLabel.setText(curso.getNombre());
        this.setCategoriaLabel.setText(curso.getCategoria());
    }
    
    public String formatoFecha(String fecha){
        String fechaFormato;
        char [] fechaArray = fecha.toCharArray();
        StringBuilder anio = new StringBuilder();
        anio.append(fechaArray[0]);
        anio.append(fechaArray[1]);
        anio.append(fechaArray[2]);
        anio.append(fechaArray[3]);
        
        StringBuilder mes = new StringBuilder();
        mes.append(fechaArray[5]);
        mes.append(fechaArray[6]);
                
        StringBuilder dia = new StringBuilder();
        dia.append(fechaArray[8]);
        dia.append(fechaArray[9]);
        
        fechaFormato = dia.toString() + "/" + mes.toString()+"/" + anio.toString();
        
        
        
        return fechaFormato;
    }
     
    
}

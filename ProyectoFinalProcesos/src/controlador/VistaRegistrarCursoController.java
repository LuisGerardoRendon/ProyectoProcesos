/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Alertas;
import modelo.Curso_DAO_Implements;
import java.util.Calendar;
import javafx.stage.Stage;
import modelo.CursoVO;

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
    private Button botonRegistrar;
    @FXML
    private Button botonCancelar;
    
    
    @FXML
    private TextField textfieldDiaInicio;
    @FXML
    private Label labelCategoria;
    @FXML
    private ComboBox<String> comboBoxCategoria;
    @FXML
    private ComboBox<String> comboAnioInicio;
    @FXML
    private ComboBox<String> comboMesInicio;
    @FXML
    private TextField textfieldDiaFin;
    @FXML
    private ComboBox<String> comboAnioFin;
    @FXML
    private ComboBox<String> comboMesFin;
    
    Alertas alertas = new Alertas();
    Curso_DAO_Implements curso_DAO = new Curso_DAO_Implements();
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializaCombos();
    }    

    @FXML
    private void registrar(ActionEvent event) {
        //String nombre = textfieldNombre.getText();
        //int cupo = Integer.parseInt(textfieldCupo.getText());
        //int creditos = Integer.parseInt(textfieldCreditos.getText());
        
        if(validarCampos()){
            CursoVO curso = crearCurso();
            if(curso_DAO.registrar(curso)){
                alertas.alertaInformacion("CURSO REGISTRADO!!");
                limpiarCampos();
            }
            
        }
        
        
        
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Stage stage = (Stage) this.botonCancelar.getScene().getWindow();
        stage.close();
    }
    
    public boolean validaFecha(){
        boolean valido = false;
        int diaFin = Integer.parseInt(textfieldDiaFin.getText());
        int mesFin = Integer.parseInt(comboMesFin.getValue());
        int anioFin = Integer.parseInt(comboAnioFin.getValue());
        
        int diaInicio = Integer.parseInt(textfieldDiaInicio.getText());
        int mesInicio = Integer.parseInt(comboMesInicio.getValue());
        int anioInicio = Integer.parseInt(comboAnioInicio.getValue());
        
        LocalDate fechaDeHoy = generarFechaHoy();
        
        
        LocalDate fechaFin = LocalDate.of(anioFin, mesFin, diaFin);
        LocalDate fechaInicio = LocalDate.of(anioInicio, mesInicio, diaInicio);
        
        if(fechaDeHoy.isBefore(fechaInicio)){
            if(fechaInicio.isBefore(fechaFin)){
                valido = true;
            }
        }
        
        
        
        if(diaInicio<diaFin){
            
        }
        return valido;
    }
    public LocalDate generarFechaHoy(){
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) +1;
        int anio = calendario.get(Calendar.YEAR);
        LocalDate fecha = LocalDate.of(anio,mes,dia);
        return fecha;
    }
    
    
    public boolean validarCampos(){
        boolean valido = false;
        if(datosLlenos()){
            if(combosSeleccionados()){
                if(validarEnteros()){
                    if(validaFecha()){
                        valido = true;
                    }else{
                        alertas.alertaInformacion("Por favor, revise que las fechas sean concistentes");
                    }
                }else{
                    alertas.alertaInformacion("Datos invalidos, asegurese que ingrese datos numericos donde corresponde");
                }
            }else{
                alertas.alertaInformacion("Por favor, complete la informacón");
            }
        }else{
            alertas.alertaInformacion("Por favor, llene los cmapos vacíos");
        }
        
        return valido;
    }
    
    public boolean datosLlenos(){
        boolean valido = false;
        if(textfieldDiaInicio.getText()!=null){
            if( textfieldNombre.getText()!=null){
                if(textfieldCupo.getText()!=null){
                    if(textfieldCreditos.getText()!=null){
                        if(textfieldDiaFin.getText()!=null){
                            valido = true;
                        }
                    }
                } 
            }
            
        }
        return valido;
    }
    
    
    public void inicializaCombos(){
        ObservableList<String> listaMeses =  FXCollections.observableArrayList();
        for(int i = 1; i<13; i++){
            listaMeses.add(i+"");
        }
        comboMesFin.setItems(listaMeses);
        comboMesInicio.setItems(listaMeses);
        ObservableList<String> listaAnios = FXCollections.observableArrayList();
        listaAnios.add("2020");
        listaAnios.add("2021");
        listaAnios.add("2022");
        
        comboAnioFin.setItems(listaAnios);
        comboAnioInicio.setItems(listaAnios);
        
        ObservableList<String> listaCategorias = FXCollections.observableArrayList();
        listaCategorias.add("Educacion");
        listaCategorias.add("Deportes");
        listaCategorias.add("Salud");
        listaCategorias.add("Negocios");
        comboBoxCategoria.setItems(listaCategorias);
    }
    public boolean combosSeleccionados(){
        boolean valido = false;
        if(comboMesFin.getValue()!=null){
            if(comboMesInicio.getValue()!=null){
                if(comboAnioFin.getValue()!=null){
                    if(comboAnioInicio.getValue()!=null){
                        if(comboBoxCategoria.getValue()!=null){
                            valido = true;
                        }
                    }
                }
            }
        }
        return  valido;
    }
    
    
    public boolean validarEnteros(){
        boolean valido = false;
        try{
            int cupo = Integer.parseInt(textfieldCupo.getText());
            int creditos = Integer.parseInt(textfieldCreditos.getText());
            int diaInicio = Integer.parseInt(textfieldDiaInicio.getText());
            int diaFin = Integer.parseInt(textfieldDiaFin.getText());
            valido = true;
        }catch(NumberFormatException e){
            
        }
        
        return  valido;
    }
    public  CursoVO crearCurso(){
        
        int diaFin = Integer.parseInt(textfieldDiaFin.getText());
        int mesFin = Integer.parseInt(comboMesFin.getValue());
        int anioFin = Integer.parseInt(comboAnioFin.getValue());
        int diaInicio = Integer.parseInt(textfieldDiaInicio.getText());
        int mesInicio = Integer.parseInt(comboMesInicio.getValue());
        int anioInicio = Integer.parseInt(comboAnioInicio.getValue());
        
        /*Date fechaFin = new Date();
        fechaFin.setDate(diaFin);
        fechaFin.setMonth(mesFin);
        fechaFin.setYear(anioFin);*/
        LocalDate fechaFin = LocalDate.of(anioFin, mesFin, diaFin);


        /*Date fechaInicio = new Date();
        fechaInicio.setDate(diaInicio);
        fechaInicio.setMonth(mesInicio);
        fechaInicio.setYear(anioInicio);*/
        LocalDate fechaInicio = LocalDate.of(anioInicio, mesInicio, diaInicio);
        
        
        int cupo = Integer.parseInt(textfieldCupo.getText());
        int creditos = Integer.parseInt(textfieldCreditos.getText());
        String nombre = textfieldNombre.getText();
        String categoria = comboBoxCategoria.getValue();
        
        CursoVO curso = new CursoVO(nombre, categoria, fechaInicio, fechaFin, cupo, creditos, "null", "Disponible");
        
        return curso;
    }
    public void limpiarCampos(){
        textfieldDiaFin.setText("");
        comboMesFin.setValue("");
        comboAnioFin.setValue("");
        textfieldDiaInicio.setText("");
        comboMesInicio.setValue("");
        comboAnioInicio.setValue("");
        textfieldCupo.setText("");
        textfieldCreditos.setText("");
        textfieldNombre.setText("");
        comboBoxCategoria.setValue("");
    }
    
    
}

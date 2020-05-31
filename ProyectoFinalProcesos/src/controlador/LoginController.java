/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.AdministradorVO;
import modelo.Administrador_DAO_Implements;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class LoginController implements Initializable {

    @FXML
    private Label labelCursos;
    @FXML
    private Label labelUsuario;
    @FXML
    private Label labelContrasenia;
    @FXML
    private TextField textFieldUsuario;
    @FXML
    private PasswordField textFieldContrasenia;
    @FXML
    private Button botonLogin;
    @FXML
    private Button botonRegistrar;

    Administrador_DAO_Implements administrador_DAO = new Administrador_DAO_Implements();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) {
        String usuario = textFieldUsuario.getText();
        String contrasenia = textFieldContrasenia.getText();

        AdministradorVO administrador = new AdministradorVO(usuario, contrasenia);
        if (administrador_DAO.login(administrador)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/vistaMostrarCursos.fxml"));
                Parent root = loader.load();
                VistaMostrarCursosController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();
                Stage stage1 = (Stage) this.botonLogin.getScene().getWindow();
                stage1.close();

            } catch (IOException e) {
            }

        }
    }

    @FXML
    private void registrar(ActionEvent event) {
    }

}

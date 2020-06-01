/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Administrador_DAO_Implements implements Administrador_DAO{

    @Override
    public boolean login(AdministradorVO administrador) {
        boolean logeado = false;
        String usuario = administrador.getUsuario();
        String contrasenia = administrador.getContrasenia();
        String sql = "SELECT * FROM administrador WHERE usuario = '" + usuario + "' AND contrasenia = '" + contrasenia + "' ;";
        System.out.println("SQL UTILIZADO" + sql);
        ObservableList<AdministradorVO> administradores = this.ejecutarUsuariosConsulta(sql);
        if(administradores.contains(administrador)){
            logeado = true;
        }
        return logeado;
    }

    @Override
    public ObservableList<AdministradorVO> ejecutarUsuariosConsulta(String consulta) {
        
        ObservableList<AdministradorVO> usuarios = FXCollections.observableArrayList();
        Connection con = null;
        Statement stm = null;
        ConexionBD cc = new ConexionBD();
        ResultSet rs = null;
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(consulta);
            while (rs.next()) {
                AdministradorVO usuarioRecuperado = new AdministradorVO(rs.getString("usuario"),
                        rs.getString("contrasenia"));
                usuarios.add(usuarioRecuperado);
            }

            con.close();
            stm.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("ERROR EN EJECUTAR CONSULTA:  ");
            e.printStackTrace();

        }
        return usuarios;
      
    }

}

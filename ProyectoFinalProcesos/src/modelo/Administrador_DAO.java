/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import javafx.collections.ObservableList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface Administrador_DAO {
    boolean login(AdministradorVO administrador);
    public ObservableList<AdministradorVO> ejecutarUsuariosConsulta(String consulta);
}

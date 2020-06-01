/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.time.LocalDate;
import javafx.collections.ObservableList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface Curso_DAO {
    boolean registrar(CursoVO curso);
    ObservableList<CursoVO> recuperarCursos(String status);
    ObservableList<CursoVO> ejecutarConsulta(String consulta);
    LocalDate obtenerFecha(String fecha);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Curso_DAO_Implements implements Curso_DAO{

    @Override
    public boolean registrar(CursoVO curso) {
        boolean creado = false;
        Statement stm = null;
        Connection con = null;
        String nrc = curso.getNrc();
        LocalDate fechaInicio = curso.getFechaInicio();
        LocalDate fechaFin = curso.getFechaFin();
        String fechaInicioCadena = fechaInicio.toString();
        String fechaFinCadena = fechaFin.toString();
        /*if(fechaInicio.getDay()<10){
            fechaInicioCadena = fechaInicio.getYear() + "-" + fechaInicio.getMonth()+ "-0" +fechaInicio.getDate();
        }else{
            fechaInicioCadena = fechaInicio.getYear() + "-" + fechaInicio.getMonth()+ "-" +fechaInicio.getDate();
        }
        Date fechaFin = curso.getFechaFin();
        if(fechaFin.getDay()<10){
            fechaFinCadena = fechaFin.getYear() + "-" + fechaFin.getMonth()+ "-0" +fechaFin.getDate();
        }else{
            fechaFinCadena = fechaFin.getYear() + "-" + fechaFin.getMonth()+ "-" +fechaFin.getDate();
        }*/
        
        String nombre = curso.getNombre();
        int cupo = curso.getCupo();
        int creditos = curso.getCreditos();
        String categoria = curso.getCategoria();
        String status = curso.getStatus();
        String sql = "INSERT INTO curso VALUES('" + nombre + "'";
        sql += ", " + cupo + ", "+ creditos + ", " + nrc + ", ";
        sql += "'"+fechaInicioCadena+"', " + "'" + fechaFinCadena+ "', " ;
        sql += "'" + categoria + "', '"+ status + "');";
        System.out.println("SQL EJECUTADO: " + sql);    
        
        ConexionBD cc = new ConexionBD();
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            creado = true;
            con.close();
            stm.close();
        } catch (SQLException e) {
            System.out.println("Error, Clase Producto_DAO_Imp, metodo create");
            e.printStackTrace();
        }
        return creado;
    }

    @Override
    public ObservableList<CursoVO> recuperarCursos(String status) {
        String sql;
        if(status.equals("Todos")){
            sql = "SELECT * FROM curso ;";
        }else{
            sql = "SELECT * FROM curso WHERE status = '" +status + "';";
        }
        System.out.println("SQL ejecutado: " + sql);
        ObservableList<CursoVO>cursosRecuperados = ejecutarConsulta(sql);
        return  cursosRecuperados;
    }

    @Override
    public ObservableList<CursoVO> ejecutarConsulta(String consulta) {
        ObservableList<CursoVO> cursos = FXCollections.observableArrayList();
        Connection con = null;
        Statement stm = null;
        ConexionBD cc = new ConexionBD();
        ResultSet rs = null;
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(consulta);
            //CursoVO(String nombre, String categoria, Date fechaInicio, Date fechaFin, int cupo, int creditos, String nrc, String status)
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                LocalDate fechaInicio = obtenerFecha(rs.getString("fechaInicio"));
                LocalDate fechaFin = obtenerFecha(rs.getString("fechaFin"));
                int cupo = rs.getInt("cupo");
                int creditos = rs.getInt("creditos");
                String nrc = Integer.toString(rs.getInt("nrc"));
                String status = rs.getString("status");
                CursoVO cursoRecuperado = new CursoVO(nombre, categoria, fechaInicio, fechaFin, cupo, creditos, nrc, status);
                cursos.add(cursoRecuperado);
            }

            con.close();
            stm.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("ERROR EN EJECUTAR CONSULTA:  ");
            e.printStackTrace();

        }
        return cursos;
    }
    
    public LocalDate obtenerFecha(String fecha){
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
        
        System.out.println(anio.toString() +"  " + mes.toString() + "  " + dia.toString());
        
        int anioInt = Integer.parseInt(anio.toString());
        int mesInt = Integer.parseInt(mes.toString());
        int diaInt = Integer.parseInt(dia.toString());
        
        LocalDate time = LocalDate.of(anioInt,mesInt,diaInt);
        return  time;
        
    }

}

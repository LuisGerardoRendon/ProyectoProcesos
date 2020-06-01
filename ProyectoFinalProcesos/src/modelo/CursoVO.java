/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.time.LocalDate;
import java.util.Date;

/**
 * 
 * @author 
 */
public class CursoVO {
    private String nombre, categoria, nrc;
    private LocalDate fechaInicio, fechaFin;
    private int cupo, creditos; 
    private String status;

    public CursoVO(String nombre, String categoria, LocalDate fechaInicio, LocalDate fechaFin, int cupo, int creditos, String nrc, String status) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cupo = cupo;
        this.creditos = creditos;
        this.nrc = nrc; //llave primaria
        this.status = status;
        
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCupo() {
        return cupo;
    }

    public int getCreditos() {
        return creditos;
    }

    public String getNrc() {
        return nrc;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
    
}

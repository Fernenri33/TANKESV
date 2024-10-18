package com.app.tankesv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Reporte_Usuario {

    public Reporte_Usuario() {
    }

    @Id
    private int id_reporteUsuario;

    @Column(name="id_usuario")
    private int idUsuario;

    @Column(name="motivo")
    private String motivo;

    @Column(name="url_img")
    private String urlImg;


    public int getId_reporteUsuario() {
        return this.id_reporteUsuario;
    }

    public void setId_reporteUsuario(int id_reporteUsuario) {
        this.id_reporteUsuario = id_reporteUsuario;
    }

    public int getidUsuario() {
        return this.idUsuario;
    }

    public void setidUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getUrlImg() {
        return this.urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

}

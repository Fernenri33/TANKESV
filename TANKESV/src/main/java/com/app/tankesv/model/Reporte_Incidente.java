package com.app.tankesv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Reporte_Incidente {

    //Constructor
    public Reporte_Incidente()
    {}

    @Id
    private int id_reporteIncidente;

    @Column(name = "descripcionProblema")
    private String descripcionProblema;

    @Column(name = "url_img")
    private String url_img;

    public int getId_reporteIncidente() {
        return id_reporteIncidente;
    }

    public void setId_reporteIncidente(int id_reporteIncidente) {
        this.id_reporteIncidente = id_reporteIncidente;
    }

    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }
}

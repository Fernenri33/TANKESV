package com.app.tankesv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GestionCatalogo {

    @Id
    private int Id;

    @Column (name = "nombreProducto")
    private String nombreProducto;

    @Column (name = "descripcionProducto")
    private String descripcionProducto;

    @Column (name = "precioProducto")
    private double precioProducto;

    @Column (name = "cantidadProducto")
    private int cantidadProducto;

    @Column (name = "imagenProducto")
    private String imagenProducto;

    //CONSTRUCTOR
    public GestionCatalogo() {
    }
    
    //GETTERS
    public int getId() {
        return Id;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public String getDescripcionProducto() {
        return descripcionProducto;
    }
    public double getPrecioProducto() {
        return precioProducto;
    }
    public int getCantidadProducto() {
        return cantidadProducto;
    }
    public String getImagenProducto() {
        return imagenProducto;
    }

    //SETTERS
    public void setId(int id) {
        Id = id;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }
}

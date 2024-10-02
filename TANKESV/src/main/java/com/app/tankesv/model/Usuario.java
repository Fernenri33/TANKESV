package com.app.tankesv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    
    @Id
    private int id_usuario;

    @Column(name="nombre", length = 100)
    private String nombre;

    @Column(name="correo", length = 100)
    private String correo;

    @Column(name="password", length = 100)
    private String password;

    @Column(name="tipo")
    private String tipo;


    public Usuario() {
    }


    public int getId_usuario() {
        return this.id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "{" +
            " id_usuario='" + getId_usuario() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", correo='" + getCorreo() + "'" +
            ", password='" + getPassword() + "'" +
            ", tipo='" + getTipo() + "'" +
            "}";
    }
    
}

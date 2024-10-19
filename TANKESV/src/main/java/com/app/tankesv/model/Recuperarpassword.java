package com.app.tankesv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Recuperarpassword {

    @Id
    @Column(name = "recuperarpassword_id")
    private int idRecuperarpassword;

    @Column(name = "id_usuario")
    private int idUsuario;

    // Getters y Setters
    public int getIdRecuperarpassword() {
        return idRecuperarpassword;
    }

    public void setIdRecuperarpassword(int idRecuperarpassword) {
        this.idRecuperarpassword = idRecuperarpassword;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

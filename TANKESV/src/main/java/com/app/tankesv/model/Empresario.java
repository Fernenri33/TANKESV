package com.app.tankesv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresario")
public class Empresario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresario")
    private int idEmpresario;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Empresario() {
    }

    public int getIdEmpresario() {
        return this.idEmpresario;
    }

    public void setIdEmpresario(int idEmpresario) {
        this.idEmpresario = idEmpresario;
    }


    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

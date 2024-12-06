package com.app.tankesv.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empresario")
public class Empresario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresario")
    private int idEmpresario;

    @Column(name = "nombre_emprendimiento", nullable = false)
    private String nombreEmprendimiento;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "num_telefono", nullable = false)
    private String numTelefono;

    @Column(name = "facebook_link")
    private String facebookLink;

    @Column(name = "wsp_link")
    private String wspLink;

    @Column(name = "industria", nullable = false)
    private String industria;

    // Relación con la entidad Usuario
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuario usuario;

    // Getters y Setters
    public int getIdEmpresario() {
        return idEmpresario;
    }

    public void setIdEmpresario(int idEmpresario) {
        this.idEmpresario = idEmpresario;
    }

    public String getNombreEmprendimiento() {
        return nombreEmprendimiento;
    } 

    public void setNombreEmprendimiento(String nombreEmprendimiento) {
        this.nombreEmprendimiento = nombreEmprendimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getWspLink() {
        return wspLink;
    }

    public void setWspLink(String wspLink) {
        this.wspLink = wspLink;
    }

    public String getIndustria() {
        return industria;
    }

    public void setIndustria(String industria) {
        this.industria = industria;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

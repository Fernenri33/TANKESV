package com.app.tankesv.model;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "crowdfunding")
public class Crowdfunding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_crowdfunding")
    private int idCrowdfunding;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "meta")
    private BigDecimal meta;

    @Column(name = "recaudado")
    private BigDecimal recaudado;

    @ManyToOne
    @JoinColumn(name = "id_empresario")
    private Empresario empresario;

    @Column(name = "main_img")
    private String main_img;

    @OneToMany(mappedBy = "crowdfunding", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CrowdfundingImg> imagenes;    

    public Crowdfunding() {
    }

    public int getIdCrowdfunding() {
        return this.idCrowdfunding;
    }

    public void setIdCrowdfunding(int idCrowdfunding) {
        this.idCrowdfunding = idCrowdfunding;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getMeta() {
        return this.meta;
    }

    public void setMeta(BigDecimal meta) {
        this.meta = meta;
    }

    public BigDecimal getRecaudado() {
        return this.recaudado;
    }

    public void setRecaudado(BigDecimal recaudado) {
        this.recaudado = recaudado;
    }

    public Empresario getEmpresario() {
        return this.empresario;
    }

    public void setEmpresario(Empresario empresario) {
        this.empresario = empresario;
    }

    public Set<CrowdfundingImg> getImagenes() {
        return this.imagenes;
    }

    public void setImagenes(Set<CrowdfundingImg> imagenes) {
        this.imagenes = imagenes;
    }

    public String getMain_img() {
        return this.main_img;
    }

    public void setMain_img(String main_img) {
        this.main_img = main_img;
    }

}

package com.app.tankesv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "crowdfunding_img")
public class CrowdfundingImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_crowdfunding_img")
    private int idCrowdfundingImg;

    @Column(name = "url_img", nullable = false)
    private String urlImg;

    @ManyToOne
    @JoinColumn(name = "id_crowdfunding", nullable = false)
    private Crowdfunding crowdfunding;


    public CrowdfundingImg() {
    }

    public int getIdCrowdfundingImg() {
        return this.idCrowdfundingImg;
    }

    public void setIdCrowdfundingImg(int idCrowdfundingImg) {
        this.idCrowdfundingImg = idCrowdfundingImg;
    }

    public String getUrlImg() {
        return this.urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Crowdfunding getCrowdfunding() {
        return this.crowdfunding;
    }

    public void setCrowdfunding(Crowdfunding crowdfunding) {
        this.crowdfunding = crowdfunding;
    }
  
}

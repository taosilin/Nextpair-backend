package com.example.backend.model;

import javax.persistence.*;

public class Lens {
    @Id
    private String lensID;

    private String lensName;

    private Double price;

    private String refractiveIndex;

    private String material;

    private String radian;

    private String variety;

    private String film;

    private String design;

    private String state;

    private String description;

    private String descriptionB;

    private Integer deliveryTime;

    private Double sphMin;

    private Double sphMax;

    private Double cylMin;

    private Double cylMax;

    private String classification;

    public String getLensID() {
        return lensID;
    }

    public void setLensID(String lensID) {
        this.lensID = lensID;
    }

    public String getLensName() {
        return lensName;
    }

    public void setLensName(String lensName) {
        this.lensName = lensName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRefractiveIndex() {
        return refractiveIndex;
    }

    public void setRefractiveIndex(String refractiveIndex) {
        this.refractiveIndex = refractiveIndex;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getRadian() {
        return radian;
    }

    public void setRadian(String radian) {
        this.radian = radian;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionB() {
        return descriptionB;
    }

    public void setDescriptionB(String descriptionB) {
        this.descriptionB = descriptionB;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Double getSphMin() {
        return sphMin;
    }

    public void setSphMin(Double sphMin) {
        this.sphMin = sphMin;
    }

    public Double getSphMax() {
        return sphMax;
    }

    public void setSphMax(Double sphMax) {
        this.sphMax = sphMax;
    }

    public Double getCylMin() {
        return cylMin;
    }

    public void setCylMin(Double cylMin) {
        this.cylMin = cylMin;
    }

    public Double getCylMax() {
        return cylMax;
    }

    public void setCylMax(Double cylMax) {
        this.cylMax = cylMax;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}

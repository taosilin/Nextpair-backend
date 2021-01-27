package com.example.backend.model;

import javax.persistence.*;

public class LensStock {
    @Id
    private String stockID;

    private String lensID;

    private Double sph;

    private Double cyl;

    private Integer stock;

    private Integer warning;

    public String getStockID() {
        return stockID;
    }

    public void setStockID(String stockID) {
        this.stockID = stockID;
    }

    public String getLensID() {
        return lensID;
    }

    public void setLensID(String lensID) {
        this.lensID = lensID;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getSph() {
        return sph;
    }

    public void setSph(Double sph) {
        this.sph = sph;
    }

    public Double getCyl() {
        return cyl;
    }

    public void setCyl(Double cyl) {
        this.cyl = cyl;
    }

    public Integer getWarning() {
        return warning;
    }

    public void setWarning(Integer warning) {
        this.warning = warning;
    }
}

package com.example.backend.model;

import javax.persistence.*;

public class Cart {
    @Id
    private String userID;

    private String productID;

    private String specID;

    private Integer num;

    private String lensID;

    private Double leftDegree;

    private Double rightDegree;

    private Integer interpupillary;

    private Double leftAstigmatism;

    private Double rightAstigmatism;

    private Integer leftAxis;

    private Integer rightAxis;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getSpecID() {
        return specID;
    }

    public void setSpecID(String specID) {
        this.specID = specID;
    }

    public Double getLeftDegree() {
        return leftDegree;
    }

    public void setLeftDegree(Double leftDegree) {
        this.leftDegree = leftDegree;
    }

    public Double getRightDegree() {
        return rightDegree;
    }

    public void setRightDegree(Double rightDegree) {
        this.rightDegree = rightDegree;
    }

    public Integer getInterpupillary() {
        return interpupillary;
    }

    public void setInterpupillary(Integer interpupillary) {
        this.interpupillary = interpupillary;
    }

    public Double getLeftAstigmatism() {
        return leftAstigmatism;
    }

    public void setLeftAstigmatism(Double leftAstigmatism) {
        this.leftAstigmatism = leftAstigmatism;
    }

    public Double getRightAstigmatism() {
        return rightAstigmatism;
    }

    public void setRightAstigmatism(Double rightAstigmatism) {
        this.rightAstigmatism = rightAstigmatism;
    }

    public Integer getLeftAxis() {
        return leftAxis;
    }

    public void setLeftAxis(Integer leftAxis) {
        this.leftAxis = leftAxis;
    }

    public Integer getRightAxis() {
        return rightAxis;
    }

    public void setRightAxis(Integer rightAxis) {
        this.rightAxis = rightAxis;
    }

    public String getLensID() {
        return lensID;
    }

    public void setLensID(String lensID) {
        this.lensID = lensID;
    }
}

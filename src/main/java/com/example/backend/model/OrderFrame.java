package com.example.backend.model;

import javax.persistence.*;

public class OrderFrame {
    @Id
    private String orderID;

    private String frameID;

    private String lensID;

    private String specID;

    private String state;

    private Integer num;

    private Double price;

    private Double actualPayment;

    private Double leftDegree;

    private Double rightDegree;

    private Integer interpupillary;

    private Double leftAstigmatism;

    private Double rightAstigmatism;

    private Integer leftAxis;

    private Integer rightAxis;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getLensID() {
        return lensID;
    }

    public void setLensID(String lensID) {
        this.lensID = lensID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public String getSpecID() {
        return specID;
    }

    public void setSpecID(String specID) {
        this.specID = specID;
    }

    public Double getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(Double actualPayment) {
        this.actualPayment = actualPayment;
    }
}

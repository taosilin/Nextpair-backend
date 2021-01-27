package com.example.backend.model;

import javax.persistence.*;
import java.sql.Timestamp;

public class Refund {
    @Id
    private String refundID;

    private String orderID;

    private String productID;

    private String specID;

    private String lensID;

    private String applicant;

    private Double amount;

    private String reason;

    private String description;

    private String state;

    private String type;

    private Timestamp updateTime;

    private String refundImage;

    private Double leftDegree;

    private Double rightDegree;

    private Integer interpupillary;

    private Double leftAstigmatism;

    private Double rightAstigmatism;

    private Integer leftAxis;

    private Integer rightAxis;

    public String getRefundID() {
        return refundID;
    }

    public void setRefundID(String refundID) {
        this.refundID = refundID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecID() {
        return specID;
    }

    public void setSpecID(String specID) {
        this.specID = specID;
    }

    public String getRefundImage() {
        return refundImage;
    }

    public void setRefundImage(String refundImage) {
        this.refundImage = refundImage;
    }

    public String getLensID() {
        return lensID;
    }

    public void setLensID(String lensID) {
        this.lensID = lensID;
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
}

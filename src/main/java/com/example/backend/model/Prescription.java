package com.example.backend.model;

import javax.persistence.*;

public class Prescription {
    @Id
    private String prescriptionID;

    private String userID;

    private String prescriptionName;

    private Double leftDegree;

    private Double rightDegree;

    private Integer interpupillary;

    private Double leftAstigmatism;

    private Double rightAstigmatism;

    private Integer leftAxis;

    private Integer rightAxis;

    public String getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(String prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
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

package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Prescription;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrescriptionMapper extends Mapper<Prescription>{
    public void addPrescription(Prescription p);
    public void deleteByPrescriptionID(@Param("prescriptionID")String prescriptionID);
    public void updatePrescription(Prescription p);
    public List<Prescription> userPrescriptionList(@Param("userID")String userID);
    public Prescription findByPrescriptionID(@Param("prescriptionID")String prescriptionID);
}

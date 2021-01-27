package com.example.backend.web.model;

import com.example.backend.model.Class;

import java.util.List;

//上级分类列表
public class SuperiorClass {
    public Integer classID;
    public String className;
    public List<SuperiorClass> children;
}

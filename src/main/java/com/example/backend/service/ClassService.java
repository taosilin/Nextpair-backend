package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Class;
import com.example.backend.web.model.SuperiorClass;

import java.util.List;

public interface ClassService extends Service<Class> {
    void addClass(Class c);
    void updateClass(Class c);
    void deleteClass(Integer classID);
    List<Class> classList(Integer page,Integer size);
    List<SuperiorClass> superiorClass(Integer superior);
    Integer classTotal();
}

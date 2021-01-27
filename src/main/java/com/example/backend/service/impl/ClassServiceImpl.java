package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.ClassMapper;
import com.example.backend.model.Class;
import com.example.backend.service.ClassService;
import com.example.backend.core.AbstractService;

import com.example.backend.web.model.SuperiorClass;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClassServiceImpl extends AbstractService<Class> implements ClassService{
    @Resource
    private ClassMapper classMapper;

    public void addClass(Class c){
        classMapper.addClass(c);
    }

    public void updateClass(Class c){
        classMapper.updateClass(c);
    }

    public void deleteClass(Integer classID){
        classMapper.deleteClass(classID);
        List<Class> list = classMapper.findBySuperior(classID);
        if (!list.isEmpty()){
            for (Class c:list){
                this.deleteClass(c.getClassID());
            }
        }
    }

    public List<Class> classList(Integer page,Integer size){
        return classMapper.classList(page*size, size);
    }

    public List<SuperiorClass> superiorClass(Integer superior){
       List<Class> list = classMapper.findBySuperior(superior);
       List<SuperiorClass> result = new ArrayList<>();
       if(!list.isEmpty()){
           for (Class c:list){
               SuperiorClass s = new SuperiorClass();
               s.classID = c.getClassID();
               s.className = c.getClassName();
               s.children = this.superiorClass(c.getClassID());
               result.add(s);
           }
       }
       return result;
    }

    public Integer classTotal(){
        return classMapper.classTotal();
    }
}

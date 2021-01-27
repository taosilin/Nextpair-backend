package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.ProblemMapper;
import com.example.backend.model.Problem;
import com.example.backend.service.ProblemService;
import com.example.backend.core.AbstractService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ProblemServiceImpl extends AbstractService<Problem> implements ProblemService{
    @Resource
    private ProblemMapper problemMapper;

    public void addProblem(Problem p){
        problemMapper.addProblem(p);
    }

    public List<Problem> problemList(Integer page,Integer size){
        return problemMapper.problemList(page*size,size);
    }

    public void updateProblem(Problem p){
        problemMapper.updateProblem(p);
    }

    public void deleteProblem(Integer problemID){
        problemMapper.deleteProblem(problemID);
    }

    public Integer problemTotal(){
        return problemMapper.problemTotal();
    }
}

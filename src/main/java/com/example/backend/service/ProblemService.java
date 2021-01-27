package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Problem;

import java.util.List;

public interface ProblemService extends Service<Problem> {
    void addProblem(Problem p);
    List<Problem> problemList(Integer page,Integer size);
    void updateProblem(Problem p);
    void deleteProblem(Integer problemID);
    Integer problemTotal();
}

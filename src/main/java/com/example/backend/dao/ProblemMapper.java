package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Problem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProblemMapper extends Mapper<Problem> {
    public void addProblem(Problem p);
    public List<Problem> problemList(@Param("page")Integer page,@Param("size")Integer size);
    public void updateProblem(Problem p);
    public void deleteProblem(@Param("problemID")Integer problemID);
    public Integer problemTotal();
}

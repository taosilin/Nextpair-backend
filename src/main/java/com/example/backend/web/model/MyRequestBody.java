package com.example.backend.web.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MyRequestBody {
    public String sortedBy="";
    public Integer page=0;
    public Integer size=0;
    public String userID="";
    public BigDecimal ID;
    public BigDecimal state;

    public ArrayList<String> tags=new ArrayList<>();

}

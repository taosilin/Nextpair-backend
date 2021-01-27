package com.example.backend.web.model;

import com.example.backend.model.Lens;

import java.util.ArrayList;
import java.util.List;

// 用户可选镜片前端显示
public class EnabledLens {
    public List<Lens> specs = new ArrayList<>();
    public String lensName;
    public String description;
}

package com.example.backend.web.model;

import com.example.backend.model.Frame;
import com.example.backend.model.Spec;

import java.util.List;

public class FrameDetail {
    public Frame frame;
    public List<ValueList> attributes;
    public List<Spec> specs;
    public List<FrameColorResult> colors;
}

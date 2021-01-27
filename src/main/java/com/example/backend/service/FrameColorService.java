package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.FrameColor;

public interface FrameColorService extends Service<FrameColor> {
    void addFrameColor(FrameColor f);
    void updateFrameColor(FrameColor f);
    void deleteFrameColor(String frameID,Integer colorID);
}

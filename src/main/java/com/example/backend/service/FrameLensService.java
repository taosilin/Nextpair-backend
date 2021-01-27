package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.FrameLens;
import com.example.backend.model.Lens;
import com.example.backend.web.model.EnabledLens;
import com.example.backend.web.model.UserLensRequest;

import java.util.List;

public interface FrameLensService extends Service<FrameLens> {
    void addFrameLens(FrameLens f);
    List<Lens> lensList(String frameID);

    List<EnabledLens> enabledLens(UserLensRequest userLensRequest); //用户可选镜片前端显示

    void deleteFrameLens(FrameLens f);
}

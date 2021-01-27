package com.example.backend.service.impl;

import com.example.backend.core.AbstractService;
import com.example.backend.dao.FrameColorMapper;
import com.example.backend.model.FrameColor;
import com.example.backend.service.FrameColorService;
import com.example.backend.core.ServiceException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class FrameColorServiceImpl extends AbstractService<FrameColor> implements FrameColorService {
    @Resource
    private FrameColorMapper frameColorMapper;

    public void addFrameColor(FrameColor f){
        frameColorMapper.addFrameColor(f);
    }

    public void updateFrameColor(FrameColor f){
        frameColorMapper.updateFrameColor(f);
    }

    public void deleteFrameColor(String frameID,Integer colorID){
        frameColorMapper.deleteFrameColor(frameID, colorID);
    }
}

package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.*;
import com.example.backend.model.Attribute;
import com.example.backend.model.Frame;
import com.example.backend.model.Spec;
import com.example.backend.service.FrameService;
import com.example.backend.core.AbstractService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.backend.web.model.FrameColorResult;
import com.example.backend.web.model.FrameDetail;
import com.example.backend.web.model.ProductOverview;
import com.example.backend.web.model.ValueList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Service
@Transactional
public class FrameServiceImpl extends AbstractService<Frame> implements FrameService{
    @Resource
    private FrameMapper frameMapper;
    @Resource
    private AttributeMapper attributeMapper;
    @Resource
    private ValueMapper valueMapper;
    @Resource
    private SpecMapper specMapper;
    @Resource
    private FrameLensMapper frameLensMapper;
    @Resource
    private FrameColorMapper frameColorMapper;


    public void addFrame(Frame f){
        frameMapper.addFrame(f);
    }

    public List<Frame> frameList(Integer page,Integer size){
        return frameMapper.frameList(page*size,size);
    }

    public FrameDetail findByFrameID(String frameID){
        FrameDetail f = new FrameDetail();
        List<ValueList> valueLists = new ArrayList<>();
        List<FrameColorResult> colorResults = new ArrayList<>();

        f.frame = frameMapper.findByFrameID(frameID);

        List<Attribute> attributes = attributeMapper.attributeList(frameID);
        for (Attribute a:attributes){
            ValueList valueList = new ValueList();
            valueList.attribute = a;
            valueList.values = valueMapper.findByAttribute(a.getAttributeID());
            valueLists.add(valueList);
        }
        f.attributes = valueLists;

        f.specs=specMapper.specList(frameID);
        for (Spec s:f.specs){
            FrameColorResult frameColorResult = specMapper.findFrameSpec(s.getSpecID());
            colorResults.add(frameColorResult);
        }
        f.colors = colorResults;

        return f;
    }

    public void updateFrame(Frame f){
        frameMapper.updateFrame(f);
    }

    public void deleteFrame(String frameID){
        frameLensMapper.deleteByFrameID(frameID);
        frameColorMapper.deleteByFrameID(frameID);
        specMapper.deleteByProductID(frameID);
        List<Attribute> attributes = attributeMapper.attributeList(frameID);
        for (Attribute attribute:attributes){
            valueMapper.deleteByAttribute(attribute.getAttributeID());
            attributeMapper.deleteAttribute(attribute.getAttributeID());
        }
        frameMapper.deleteFrame(frameID);
    }

    public ProductOverview frameOverview(){
        ProductOverview p = new ProductOverview();
        p.pending = frameMapper.frameNum("0");
        p.onShelf = frameMapper.frameNum("1");
        p.offShelf = frameMapper.frameNum("2");
        p.total = frameMapper.frameTotal();
        return p;
    }

    // 查询镜框总数
    public Integer frameTotal(){
        return frameMapper.frameTotal();
    }

    public String saveImage(MultipartFile imageFile) throws Exception {
        String folder = "/root/public/frame/";
        byte[] bytes = imageFile.getBytes();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        Path path = Paths.get(folder + date +imageFile.getOriginalFilename());
        Files.write(path,bytes);
        return date + imageFile.getOriginalFilename();
    }

    // 按镜框名称搜索
    public List<Frame> searchByFrameName(String searchString){
        return frameMapper.searchByFrameName("%"+searchString+"%");
    }

    // 按分类筛选镜框
    public List<Frame> findByFrameClass(String state,String classification,Integer page,Integer size){
        return frameMapper.findByFrameClass(state,"%"+classification+"%",page*size,size);
    }
}

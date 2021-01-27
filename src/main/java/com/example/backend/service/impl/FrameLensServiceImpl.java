package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.FrameLensMapper;
import com.example.backend.model.FrameLens;
import com.example.backend.model.Lens;
import com.example.backend.service.FrameLensService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.backend.web.model.EnabledLens;
import com.example.backend.web.model.UserLensRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class FrameLensServiceImpl extends AbstractService<FrameLens> implements FrameLensService{
    @Resource
    private FrameLensMapper frameLensMapper;

    public void addFrameLens(FrameLens f){
        frameLensMapper.addFrameLens(f);
    }

    public List<Lens> lensList(String frameID){
        return frameLensMapper.lensList(frameID);
    }

    public List<EnabledLens> enabledLens(UserLensRequest userLensRequest){
        List<EnabledLens> result = new ArrayList<>();
        List<Lens> lensList = frameLensMapper.enabledLens(userLensRequest.frameID);

        if (lensList.size()>0){
            if ((userLensRequest.leftDegree.equals(0.00))&&(userLensRequest.rightDegree.equals(0.00))){
                // 仅平光
                for (Lens l:lensList){
                    Boolean flag = false;
                    for (EnabledLens e:result){
                        if (l.getLensName().equals(e.lensName)){
                            if (l.getSphMin().equals(l.getSphMax())){
                                e.specs.add(l);
                            }
                            flag = true;
                            break;
                        }
                    }

                    if (!flag){
                        EnabledLens newEnabledLens = new EnabledLens();
                        newEnabledLens.lensName = l.getLensName();
                        newEnabledLens.description = l.getDescription();
                        if (l.getSphMin().equals(l.getSphMax())){
                            newEnabledLens.specs.add(l);
                        }
                        result.add(newEnabledLens);
                    }

                }
            }
            else{
                for (Lens l:lensList){
                    Boolean flag = false;
                    for (EnabledLens e:result){
                        if (l.getLensName().equals(e.lensName)){
                            if ((l.getSphMin()<=userLensRequest.leftDegree)&&(userLensRequest.leftDegree<=l.getSphMax())
                                    &&(l.getSphMin()<=userLensRequest.rightDegree)&&(userLensRequest.rightDegree<=l.getSphMax())
                                    &&(l.getCylMin()<=userLensRequest.leftAstigmatism)&&(userLensRequest.leftAstigmatism<=l.getCylMax())
                                    &&(l.getCylMin()<=userLensRequest.rightAstigmatism)&&(userLensRequest.rightAstigmatism<=l.getCylMax())){
                                e.specs.add(l);
                            }
                            flag = true;
                            break;
                        }
                    }

                    if (!flag){
                        EnabledLens newEnabledLens = new EnabledLens();
                        newEnabledLens.lensName = l.getLensName();
                        newEnabledLens.description = l.getDescription();
                        if ((l.getSphMin()<=userLensRequest.leftDegree)&&(userLensRequest.leftDegree<=l.getSphMax())
                                &&(l.getSphMin()<=userLensRequest.rightDegree)&&(userLensRequest.rightDegree<=l.getSphMax())
                                &&(l.getCylMin()<=userLensRequest.leftAstigmatism)&&(userLensRequest.leftAstigmatism<=l.getCylMax())
                                &&(l.getCylMin()<=userLensRequest.rightAstigmatism)&&(userLensRequest.rightAstigmatism<=l.getCylMax())){
                            newEnabledLens.specs.add(l);
                        }
                        result.add(newEnabledLens);
                    }

                }
            }

            // 使用迭代器的方法删除
            Iterator<EnabledLens> iterator = result.iterator();
            while (iterator.hasNext()){
                EnabledLens e = iterator.next();
                if (e.specs.size()<=0){
                    iterator.remove();
                }
            }



        }



        return result;
    }

    public void deleteFrameLens(FrameLens f){
        frameLensMapper.deleteFrameLens(f);
    }
}

package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Lens;

import java.util.List;

public interface LensService extends Service<Lens> {
    void addLens(Lens l);
    List<Lens> lensList(Integer page,Integer size);
    void updateLens(Lens l);
    void deleteLens(String lensID);
    Lens findByLensID(String lensID);
    Integer lensTotal();
}

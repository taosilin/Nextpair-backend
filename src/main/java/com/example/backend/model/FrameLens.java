package com.example.backend.model;

import javax.persistence.*;

public class FrameLens {
    @Id
    private String frameID;

    private String lensID;

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getLensID() {
        return lensID;
    }

    public void setLensID(String lensID) {
        this.lensID = lensID;
    }
}

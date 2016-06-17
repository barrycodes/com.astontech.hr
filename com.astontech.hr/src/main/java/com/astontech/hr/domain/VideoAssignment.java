package com.astontech.hr.domain;

import javax.persistence.*;

/**
 * Created by barrsmit1 on 6/16/2016.
 */
@Entity
public class VideoAssignment extends Assignment {

    private String videoUri;

    public VideoAssignment() {
        this(null);
    }

    public VideoAssignment(String name) {
        super(name, true);
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }
}

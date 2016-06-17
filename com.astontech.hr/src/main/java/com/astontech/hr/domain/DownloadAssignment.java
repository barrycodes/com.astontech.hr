package com.astontech.hr.domain;

import javax.persistence.Entity;

/**
 * Created by barrsmit1 on 6/16/2016.
 */
@Entity
public class DownloadAssignment extends Assignment {

    public DownloadAssignment(String name) {
        super(name);
    }

}

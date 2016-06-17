package com.astontech.hr.domain;

import javax.persistence.*;

/**
 * Created by barrsmit1 on 6/16/2016.
 */
@Entity
public class LinkAssignment extends Assignment {

    private String link;

    public LinkAssignment() {
        this(null, null);
    }

    public LinkAssignment(String name) {
        this(name, null);
    }

    public LinkAssignment(String name, String link) {
        super(name, false);
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

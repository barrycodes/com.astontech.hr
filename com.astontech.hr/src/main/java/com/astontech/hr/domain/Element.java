package com.astontech.hr.domain;

import javax.persistence.*;

/**
 * Created by barrsmit1 on 6/2/2016.
 */
@Entity
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String elementName;

    public Element() {}
    public Element(String elementName) {
        this();
        this.setElementName(elementName);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }
}

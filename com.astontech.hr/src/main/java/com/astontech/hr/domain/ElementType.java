package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by barrsmit1 on 6/2/2016.
 */
@Entity
public class ElementType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ElementTypeId")
    private Integer id;

    @Version
    private Integer version;

    private String elementTypeName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Element> elements;

    public ElementType() {}

    public ElementType(String elementTypeName) {
        this();
        this.setElementTypeName(elementTypeName);
    }

    public ElementType(String elementTypeName, List<Element> elements) {
        this(elementTypeName);
        this.setElements(elements);
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

    public String getElementTypeName() {
        return elementTypeName;
    }

    public void setElementTypeName(String elementType) {
        this.elementTypeName = elementType;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}

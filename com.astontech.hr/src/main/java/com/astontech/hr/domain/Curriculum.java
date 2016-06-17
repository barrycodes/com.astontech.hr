package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by barrsmit1 on 6/15/2016.
 */
@Entity
public class Curriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AssignmentSection> sections;

    public Curriculum() {
        sections = new ArrayList<>();
    }

    public Curriculum(String name) {
        this();
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AssignmentSection> getSections() {
        return sections;
    }

    public void setSections(List<AssignmentSection> sections) {
        this.sections = sections;
    }
}

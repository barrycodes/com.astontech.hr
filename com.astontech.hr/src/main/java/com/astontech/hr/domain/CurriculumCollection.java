package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by barrsmit1 on 6/21/2016.
 */
@Entity
public class CurriculumCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Curriculum> curriculums;

    public CurriculumCollection() {
        this.curriculums = new ArrayList<>();
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

    public List<Curriculum> getCurriculums() {
        return curriculums;
    }

    public void setCurriculums(List<Curriculum> curriculums) {
        this.curriculums = curriculums;
    }
}

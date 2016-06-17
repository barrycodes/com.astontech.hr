package com.astontech.hr.domain;

import javax.persistence.*;

/**
 * Created by barrsmit1 on 6/16/2016.
 */
@Entity
public abstract class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private Boolean canBeCompleted;

    private String name;

    private String description;

    public Assignment() { }

    public Assignment(String name) {
        this(name, true);
    }

    public Assignment(String name, boolean canBeCompleted) {
        this();
        this.setName(name);
        this.canBeCompleted = canBeCompleted;
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

    public Boolean getCanBeCompleted() {
        return canBeCompleted;
    }

    public void setCanBeCompleted(Boolean canBeCompleted) {
        this.canBeCompleted = canBeCompleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

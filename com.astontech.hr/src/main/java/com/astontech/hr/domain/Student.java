package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by barrsmit1 on 6/16/2016.
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String username;

    @ManyToMany
    private Set<Assignment> assignmentsCompleted;

    public Student() {
        this.setAssignmentsCompleted(new HashSet<>());
    }

    public Student(String username) {
        this();
        this.setUsername(username);
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Assignment> getAssignmentsCompleted() {
        return assignmentsCompleted;
    }

    public void setAssignmentsCompleted(Set<Assignment> assignmentsCompleted) {
        this.assignmentsCompleted = assignmentsCompleted;
    }
}

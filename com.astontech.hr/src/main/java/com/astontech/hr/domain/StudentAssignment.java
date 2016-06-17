//package com.astontech.hr.domain;
//
//import javax.persistence.*;
//
///**
// * Created by barrsmit1 on 6/16/2016.
// */
//@Entity
//public class StudentAssignment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    @Version
//    private Integer version;
//
//    private Student student;
//    private Assignment assignment;
//    private Boolean isCompleted;
//
//    public StudentAssignment() {
//        this(null, null);
//    }
//
//    public StudentAssignment(Student student, Assignment assignment) {
//        this(student, assignment, false);
//    }
//
//    public StudentAssignment(Student student, Assignment assignment, boolean isCompleted) {
//        this.student = student;
//        this.assignment = assignment;
//        this.isCompleted = isCompleted;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getVersion() {
//        return version;
//    }
//
//    public void setVersion(Integer version) {
//        this.version = version;
//    }
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    public Assignment getAssignment() {
//        return assignment;
//    }
//
//    public void setAssignment(Assignment assignment) {
//        this.assignment = assignment;
//    }
//
//    public Boolean getIsCompleted() {
//        return isCompleted;
//    }
//
//    public void setIsCompleted(Boolean isCompleted) {
//        this.isCompleted = isCompleted;
//    }
//}

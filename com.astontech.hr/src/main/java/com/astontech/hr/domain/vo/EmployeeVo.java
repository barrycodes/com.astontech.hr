package com.astontech.hr.domain.vo;

import java.util.Date;

/**
 * Created by barrsmit1 on 6/14/2016.
 */
public class EmployeeVo {

    private Integer employeeId;
    private Integer personId;
    private Integer employeeVersion;
    private Integer personVersion;
    private String employeeCreateDate;
    private String personCreateDate;
    private String hireDate;
    private String termDate;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String displayFirstName;
    private Character gender;
    private String birthDate;
    private String ssn;
    private String fullName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayFirstName() {
        return displayFirstName;
    }

    public void setDisplayFirstName(String displayFirstName) {
        this.displayFirstName = displayFirstName;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getEmployeeVersion() {
        return employeeVersion;
    }

    public void setEmployeeVersion(Integer employeeVersion) {
        this.employeeVersion = employeeVersion;
    }

    public Integer getPersonVersion() {
        return personVersion;
    }

    public void setPersonVersion(Integer personVersion) {
        this.personVersion = personVersion;
    }

    public String getEmployeeCreateDate() {
        return employeeCreateDate;
    }

    public void setEmployeeCreateDate(String employeeCreateDate) {
        this.employeeCreateDate = employeeCreateDate;
    }

    public String getPersonCreateDate() {
        return personCreateDate;
    }

    public void setPersonCreateDate(String personCreateDate) {
        this.personCreateDate = personCreateDate;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getTermDate() {
        return termDate;
    }

    public void setTermDate(String termDate) {
        this.termDate = termDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}

package com.astontech.hr.domain.ro;

import com.astontech.hr.domain.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by barrsmit1 on 6/14/2016.
 */

public class EmployeesRo {

    public class Employees {

        @JsonProperty("employees")
        private Employee[] employees;

        public Employee[] getEmployees() {
            return employees;
        }

        public void setEmployees(Employee[] employees) {
            this.employees = employees;
        }
    }

    @JsonProperty("_embedded")
    private Employees employees;

    @JsonProperty("_links")
    private Object links;

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Object getLinks() {
        return links;
    }

    public void setLinks(Object links) {
        this.links = links;
    }
}

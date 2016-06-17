package com.astontech.hr.controllers;

import com.astontech.hr.domain.Employee;
import com.astontech.hr.domain.Simple;
import com.astontech.hr.services.EmployeeService;
import com.astontech.hr.services.impl.EmployeeServiceImpl;
import org.hibernate.jpa.internal.util.LogHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;

/**
 * Created by barrsmit1 on 6/13/2016.
 */
@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @RequestMapping(value = "/api/employee", method = RequestMethod.GET)
    public Iterable<Employee> employeeAllGet() {
        return employeeService.getAllEmployees();
    }

//    @RequestMapping(value = "/api/employee/list", method = RequestMethod.GET)
//    public Iterable<Employee> employeeListGet() {
//        return employeeService.getAllEmployees();
//    }

    @RequestMapping(value = "/api/employee/{id}", method = RequestMethod.GET)
    public Employee employeeGet(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value = "/api/employee", method = RequestMethod.POST)
    public Employee employeePost(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @RequestMapping(value = "/api/employee/{id}", method = RequestMethod.DELETE)
    public Boolean employeeDelete(@PathVariable int id) {
        boolean result = false;
        try {
            employeeService.deleteEmployee(id);
        } catch (Exception ex) {
            com.astontech.hr.common.LogHelper.getLogger().error(ex);
        }
        return result;
    }

//    @RequestMapping(value = "/admin/vehicle", method = RequestMethod.GET)
//    public String vehicleGet() {
//        return vehicleListGet(model);
//    }
//
//    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.GET)
//    public String vehicleListGet(Model model) {
//        model.addAttribute("vehicles", vehicleService.getAllVehicles());
//        return "/admin/vehicle/vehicle/vehicle_list";
//    }
}
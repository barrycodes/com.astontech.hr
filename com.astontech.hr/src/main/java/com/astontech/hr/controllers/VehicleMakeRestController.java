package com.astontech.hr.controllers;

import com.astontech.hr.domain.Employee;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.services.EmployeeService;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.impl.EmployeeServiceImpl;
import com.astontech.hr.services.impl.VehicleMakeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by barrsmit1 on 6/13/2016.
 */
@RestController
public class VehicleMakeRestController {

    @Autowired
    private VehicleMakeService vehicleMakeService = new VehicleMakeServiceImpl();

    @RequestMapping(value = "/vehiclemake", method = RequestMethod.GET)
    public Collection<VehicleMake> vehicleMakeGet() {

        Collection<VehicleMake> vehicleMakes = (Collection<VehicleMake>)vehicleMakeService.getAllVehicleMakes();

        //employees.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(SimpleController.class).simple(employees)).withSelfRel());

        return vehicleMakes;
    }


}

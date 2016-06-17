package com.astontech.hr.services;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;

/**
 * Created by barrsmit1 on 6/6/2016.
 */
public interface VehicleService {

    public Iterable<Vehicle> getAllVehicles();

    public Vehicle getVehicleById(Integer id);

    public Vehicle saveVehicle(Vehicle vehicle);

    public Iterable<Vehicle> saveVehicles(Iterable<Vehicle> vehicles);

    public void deleteVehicle(Vehicle vehicle);

    public void deleteAllVehicles();

}

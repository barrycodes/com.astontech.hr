package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;

import java.util.List;

/**
 * Created by barrsmit1 on 6/6/2016.
 */
public interface VehicleMakeService {

    public Iterable<VehicleMake> getAllVehicleMakes();

    public VehicleMake getVehicleMakeById(Integer id);

    public VehicleMake saveVehicleMake(VehicleMake vehicleMake);

    public Iterable<VehicleMake> saveVehicleMakes(Iterable<VehicleMake> vehicleMakes);

    public void deleteVehicleMake(VehicleMake vehicleMake);

    public void deleteAllVehicleMakes();

}

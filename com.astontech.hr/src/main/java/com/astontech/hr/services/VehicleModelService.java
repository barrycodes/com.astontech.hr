package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;

/**
 * Created by barrsmit1 on 6/6/2016.
 */
public interface VehicleModelService {

    public Iterable<VehicleModel> getAllVehicleModels();

    public VehicleModel getVehicleModelById(Integer id);

    public VehicleModel saveVehicleModel(VehicleModel vehicleModel);

    public Iterable<VehicleModel> saveVehicleModels(Iterable<VehicleModel> vehicleModels);

    public void deleteVehicleModel(VehicleModel vehicleModel);

    public void deleteAllVehicleModels();
    
}

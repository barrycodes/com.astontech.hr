package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by barrsmit1 on 6/6/2016.
 */
@Service
public class VehicleModelServiceImpl implements VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;
    
    @Override
    public Iterable<VehicleModel> getAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    @Override
    public VehicleModel getVehicleModelById(Integer id) {
        return vehicleModelRepository.findOne(id);
    }

    @Override
    public VehicleModel saveVehicleModel(VehicleModel vehicleModel) {
        return vehicleModelRepository.save(vehicleModel);
    }

    @Override
    public Iterable<VehicleModel> saveVehicleModels(Iterable<VehicleModel> vehicleModels) {
        return vehicleModelRepository.save(vehicleModels);
    }

    @Override
    public void deleteVehicleModel(VehicleModel vehicleModel) {
        vehicleModelRepository.delete(vehicleModel);
    }

    @Override
    public void deleteAllVehicleModels() {
        vehicleModelRepository.deleteAll();
    }

}

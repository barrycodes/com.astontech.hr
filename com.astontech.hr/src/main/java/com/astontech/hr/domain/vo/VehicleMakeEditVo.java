package com.astontech.hr.domain.vo;

import com.astontech.hr.domain.VehicleModel;

import java.util.List;

/**
 * Created by barrsmit1 on 6/7/2016.
 */
public class VehicleMakeEditVo {
    private Integer id;
    private Integer version;
    private String vehicleMakeName;
    private List<VehicleModel> vehicleModels;

    public String getVehicleMakeName() {
        return vehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }

    public List<VehicleModel> getVehicleModels() {
        return vehicleModels;
    }

    public void setVehicleModels(List<VehicleModel> vehicleModels) {
        this.vehicleModels = vehicleModels;
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
}

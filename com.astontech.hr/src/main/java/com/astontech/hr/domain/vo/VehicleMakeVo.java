package com.astontech.hr.domain.vo;

/**
 * Created by barrsmit1 on 6/6/2016.
 */
public class VehicleMakeVo {
    private String newVehicleMake;
    private String newVehicleModels;
    private String[] newVehicleModelArray;

    public VehicleMakeVo() {}

    public VehicleMakeVo(String newVehicleMake, String newVehicleModels) {
        this.setNewVehicleMake(newVehicleMake);
        this.setNewVehicleModels(newVehicleModels);
    }

    public String getNewVehicleMake() {
        return newVehicleMake;
    }

    public void setNewVehicleMake(String newVehicleMake) {
        this.newVehicleMake = newVehicleMake;
    }

    public String getNewVehicleModels() {
        return newVehicleModels;
    }

    public void setNewVehicleModels(String newVehicleModels) {
        this.newVehicleModels = newVehicleModels;
    }

    //region CUSTOM METHODS

    public void splitNewVehicleModelsIntoArray() {
        String[] result = new String[] { };
        String input = newVehicleModels.trim();
        if (!input.equals("")) {
            result = input.split("\\r?\\n");
        }
        this.setNewVehicleModelArray(result);
    }

    public String[] getNewVehicleModelArray() {
        return newVehicleModelArray;
    }

    public void setNewVehicleModelArray(String[] newVehicleModelArray) {
        this.newVehicleModelArray = newVehicleModelArray;
    }

    //endregion
}

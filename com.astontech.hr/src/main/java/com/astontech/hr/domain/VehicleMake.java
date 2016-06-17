package com.astontech.hr.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by barrsmit1 on 6/6/2016.
 */
@Entity
public class VehicleMake implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String vehicleMakeName;

    @Transient
    private String vehicleModels;

    public VehicleMake() { }

    public VehicleMake(String name) {
        this();
        this.setVehicleMakeName(name);
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

    public String getVehicleMakeName() {
        return vehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }

    public String getVehicleModels() {
        return vehicleModels;
    }

    public void setVehicleModels(String vehicleModels) {
        this.vehicleModels = vehicleModels;
    }
}

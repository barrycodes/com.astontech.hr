package com.astontech.hr.domain;

import javax.persistence.*;

/**
 * Created by barrsmit1 on 6/6/2016.
 */
@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String vehicleModelName;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)

    private VehicleMake vehicleMake;

    public VehicleModel() { }

    public VehicleModel(String name) {
        this.setVehicleModelName(name);
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

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }
}

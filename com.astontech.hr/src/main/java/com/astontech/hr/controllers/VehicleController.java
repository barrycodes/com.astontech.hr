package com.astontech.hr.controllers;

import com.astontech.hr.common.DateHelper;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.domain.vo.VehicleMakeEditVo;
import com.astontech.hr.domain.vo.VehicleMakeVo;
import com.astontech.hr.domain.vo.VehicleVo;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by barrsmit1 on 6/6/2016.
 */
@Controller
public class VehicleController {

//    @Autowired
//    private VehicleMakeService vehicleMakeService;
//
//    @Autowired
//    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleModelService vehicleModelService;

    private Logger log = Logger.getLogger(ElementController.class);

    @RequestMapping(value = "/admin/vehicle", method = RequestMethod.GET)
    public String vehicleGet(Model model) {
        return vehicleListGet(model);
    }

    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.GET)
    public String vehicleListGet(Model model) {
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "/admin/vehicle/vehicle/vehicle_list";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.GET)
    public String vehicleAddGet(Model model) {

        model.addAttribute("vehicleVo", new VehicleVo());
        model.addAttribute("vehicleModels", vehicleModelService.getAllVehicleModels());
        model.addAttribute("warningAlert", "visible");
        return "/admin/vehicle/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.POST)
    public String vehicleAddPost(VehicleVo vehicleVo, Model model, @RequestParam("vehicleModel") Integer vehicleModelId) {

        boolean success = false;

        try {
            Vehicle newVehicle = new Vehicle();
            newVehicle.setVersion(vehicleVo.getVersion());
            newVehicle.setYear(vehicleVo.getYear());
            newVehicle.setLicensePlate(vehicleVo.getLicensePlate());
            newVehicle.setVin(vehicleVo.getVin());
            newVehicle.setColor(vehicleVo.getColor());
            newVehicle.setIsPurchase(vehicleVo.getIsPurchase() == 1);
            newVehicle.setPurchasePrice(vehicleVo.getPurchasePrice());
            newVehicle.setPurchaseDate(DateHelper.getDateFromString(vehicleVo.getPurchaseDate()));
            newVehicle.setVehicleModel(vehicleModelService.getVehicleModelById(vehicleModelId));
            vehicleService.saveVehicle(newVehicle);
            success = true;
        }
        catch (Exception ex) {
            log.error(ex);
        }
        if (success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        model.addAttribute("vehicleVo", new VehicleVo());

        return "/admin/vehicle/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/delete/{id}", method = RequestMethod.GET)
    public String vehicleDeleteGet(@PathVariable int id) {

        if (id > 0) {
            try {
                deleteVehicle(id);
            } catch (Exception ex) {
                log.error(ex);
            }
        }
        return "redirect:/admin/vehicle";
    }

    @RequestMapping(value = "/admin/vehicle/edit/{id}", method = RequestMethod.GET)
    public String vehicleEditGet(@PathVariable int id, Model model) {

        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle != null) {
            VehicleVo vehicleVo = new VehicleVo();
            vehicleVo.setId(vehicle.getId());
            vehicleVo.setVersion(vehicle.getVersion());
            vehicleVo.setYear(vehicle.getYear());
            vehicleVo.setLicensePlate(vehicle.getLicensePlate());
            vehicleVo.setVin(vehicle.getVin());
            vehicleVo.setColor(vehicle.getColor());
            vehicleVo.setIsPurchase(vehicle.getIsPurchase() ? 1 : 0);
            vehicleVo.setPurchasePrice(vehicle.getPurchasePrice());
            vehicleVo.setPurchaseDate(DateHelper.getStringFromDate(vehicle.getPurchaseDate()));
            vehicleVo.setVehicleModel(vehicle.getVehicleModel());
            model.addAttribute("vehicleModels", vehicleModelService.getAllVehicleModels());
            model.addAttribute("vehicleVo", vehicleVo);
        }
        return "/admin/vehicle/vehicle/vehicle_edit";
    }

    @RequestMapping(value = "/admin/vehicle/update", method = RequestMethod.POST)
    public String vehicleUpdatePost (VehicleVo vehicleVo, Model model, @RequestParam("vehicleModelId") Integer vehicleModel) {

        Boolean success = false;

        try {
            Vehicle realVehicle = vehicleService.getVehicleById(vehicleVo.getId());

            VehicleModel realVehicleModel = vehicleModelService.getVehicleModelById(vehicleModel);

            realVehicle.setYear(vehicleVo.getYear());
            realVehicle.setLicensePlate(vehicleVo.getLicensePlate());
            realVehicle.setVin(vehicleVo.getVin());
            realVehicle.setColor(vehicleVo.getColor());
            realVehicle.setIsPurchase(vehicleVo.getIsPurchase() == 1);
            realVehicle.setPurchasePrice(vehicleVo.getPurchasePrice());
            realVehicle.setPurchaseDate(DateHelper.getDateFromString(vehicleVo.getPurchaseDate()));
            realVehicle.setVehicleModel(realVehicleModel);

            vehicleService.saveVehicle(realVehicle);

            success = true;

        } catch (Exception ex) {
            log.error(ex);
        }

        if (success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        return "redirect:/admin/vehicle/edit/" + vehicleVo.getId();
    }

    //region HELPER METHODS

    private void deleteVehicle(int id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle != null)
            vehicleService.deleteVehicle(vehicle);
    }

    //endregion
}

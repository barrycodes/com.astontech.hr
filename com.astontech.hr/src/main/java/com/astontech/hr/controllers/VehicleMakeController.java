package com.astontech.hr.controllers;

import com.astontech.hr.domain.*;
import com.astontech.hr.domain.vo.ElementVo;
import com.astontech.hr.domain.vo.VehicleMakeEditVo;
import com.astontech.hr.domain.vo.VehicleMakeVo;
import com.astontech.hr.services.ElementTypeService;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by barrsmit1 on 6/6/2016.
 */
@Controller
public class VehicleMakeController {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleService vehicleService;

    private Logger log = Logger.getLogger(ElementController.class);

    @RequestMapping(value = "/admin/vehiclemake", method = RequestMethod.GET)
    public String vehicleMakeGet(Model model) {

        Iterable<VehicleMake> allVehicleMakes = vehicleMakeService.getAllVehicleMakes();
        Iterable<VehicleModel> allVehicleModels = vehicleModelService.getAllVehicleModels();
        for (VehicleMake vehicleMake : allVehicleMakes) {

            String associatedVehicleModelsText;

            List<VehicleModel> associatedVehicleModels = new ArrayList<>();

            for (VehicleModel vehicleModel : allVehicleModels) {
                if (vehicleModel.getVehicleMake() == vehicleMake) {
                    associatedVehicleModels.add(vehicleModel);
                }
            }

            if (associatedVehicleModels.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < associatedVehicleModels.size() - 1; ++i)
                    sb.append(associatedVehicleModels.get(i).getVehicleModelName() + ", ");
                sb.append(associatedVehicleModels.get(associatedVehicleModels.size() - 1).getVehicleModelName());

                associatedVehicleModelsText = sb.toString();
            }
            else
                associatedVehicleModelsText = "(none)";

            vehicleMake.setVehicleModels(associatedVehicleModelsText);
        }
        model.addAttribute("vehicleMakes", allVehicleMakes);
        return "/admin/vehicle/vehiclemake/vehiclemake_list";

    }

    @RequestMapping(value = "/admin/vehiclemake/list", method = RequestMethod.GET)
    public String vehicleMakeListGet(Model model) {
        return vehicleMakeGet(model);
    }

    @RequestMapping(value = "/admin/vehiclemake/add", method = RequestMethod.GET)
    public String vehicleMakeAddGet(Model model) {

        model.addAttribute("vehicleMakeVo", new VehicleMakeVo());
        model.addAttribute("warningAlert", "visible");
        return "/admin/vehicle/vehiclemake/vehiclemake_add";

    }

    @RequestMapping(value = "/admin/vehiclemake/add", method = RequestMethod.POST)
    public String vehicleMakeAddPost(VehicleMakeVo vehicleMakeVo, Model model) {

        boolean success = false;

        try {
            if (!vehicleMakeVo.getNewVehicleMake().equals("")) {
                vehicleMakeVo.splitNewVehicleModelsIntoArray();

                logVehicleMakeVo(vehicleMakeVo);

                saveVehicleMakeAndVehicleModelsFromVo(vehicleMakeVo);

                success = true;
            }
        }
        catch (Exception ex) {
            log.error(ex);
        }
        if (success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        model.addAttribute("vehicleMakeVo", new VehicleMakeVo());

        return "/admin/vehicle/vehiclemake/vehiclemake_add";
    }

    @RequestMapping(value = "/admin/vehiclemake/delete/{id}", method = RequestMethod.GET)
    public String vehicleMakeDeleteGet(@PathVariable int id) {

        if (id > 0) {
            try {
                deleteVehicleMake(id);
            } catch (Exception ex) {
                log.error(ex);
            }
        }
        return "redirect:/admin/vehiclemake";
    }

    @RequestMapping(value = "/admin/vehiclemake/edit/{id}", method = RequestMethod.GET)
    public String vehicleMakeEditGet(@PathVariable int id, Model model) {

        VehicleMake make = vehicleMakeService.getVehicleMakeById(id);
        if (make != null) {
            VehicleMakeEditVo vo = new VehicleMakeEditVo();
            vo.setId(make.getId());
            vo.setVersion(make.getVersion());
            vo.setVehicleMakeName(make.getVehicleMakeName());
            vo.setVehicleModels(getVehicleModelsByMake(make));
            model.addAttribute("vehicleMakeEditVo", vo);
        }
        return "/admin/vehicle/vehiclemake/vehiclemake_edit";
    }

    @RequestMapping(value = "/admin/vehiclemake/update", method = RequestMethod.POST)
    public String vehicleMakeUpdatePost (VehicleMakeEditVo vehicleMakeEditVo,
                                        Model model,
                                        @RequestParam("inputNewVehicleModel") String newVehicleModel) {

        Boolean success = false;

        try {
            editVehicleMake(vehicleMakeEditVo, newVehicleModel);
            success = true;
        } catch (Exception ex) {
            log.error(ex);
        }
        if (success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        return "redirect:/admin/vehiclemake/edit/" + vehicleMakeEditVo.getId();
    }

    //region HELPER METHODS

    private void editVehicleMake(VehicleMakeEditVo vehicleMakeEditVo, String newVehicleModelName) {
        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(vehicleMakeEditVo.getId());

        if (!newVehicleModelName.equals("")) {

            VehicleModel newModel = new VehicleModel(newVehicleModelName);
            newModel.setVehicleMake(vehicleMake);

            if (vehicleMakeEditVo.getVehicleModels() == null) {
                List<VehicleModel> models = new ArrayList<>();
                models.add(newModel);
                vehicleMakeEditVo.setVehicleModels(models);
            } else {
                vehicleMakeEditVo.getVehicleModels().add(newModel);
            }
            vehicleModelService.saveVehicleModel(newModel);
        }
        for (int i = 0; i < vehicleMakeEditVo.getVehicleModels().size(); ++i) {

            VehicleModel vehicleModel = vehicleMakeEditVo.getVehicleModels().get(i);

            String eName = vehicleModel.getVehicleModelName();

            if (eName == null || eName.equals("")) {

                VehicleModel realVehicleModel = vehicleModelService.getVehicleModelById(vehicleModel.getId());
                List<Vehicle> vehiclesToDelete = getVehiclesByModel(realVehicleModel);
                for (Vehicle v : vehiclesToDelete) {
                    vehicleService.deleteVehicle(v);
                }
                vehicleMakeEditVo.getVehicleModels().remove(i);

                vehicleModelService.deleteVehicleModel(realVehicleModel);
            }
            VehicleModel realVehicleModel = vehicleModelService.getVehicleModelById(vehicleModel.getId());
            realVehicleModel.setVehicleModelName(vehicleModel.getVehicleModelName());
            vehicleModelService.saveVehicleModel(realVehicleModel);
        }
        vehicleMake.setVehicleMakeName(vehicleMakeEditVo.getVehicleMakeName());
        vehicleMakeService.saveVehicleMake(vehicleMake);
    }

    private List<VehicleModel> getVehicleModelsByMake(VehicleMake make) {
        List<VehicleModel> results = new ArrayList<>();
        Iterable<VehicleModel> allModels = vehicleModelService.getAllVehicleModels();
        for (VehicleModel model : allModels) {
            if (model.getVehicleMake() == make)
                results.add(model);
        }
        return results;
    }

    private List<Vehicle> getVehiclesByModel(VehicleModel model) {
        List<Vehicle> results = new ArrayList<>();
        Iterable<Vehicle> allVehicles = vehicleService.getAllVehicles();
        for (Vehicle vehicle : allVehicles) {
            if (vehicle.getVehicleModel() == model) {
                results.add(vehicle);
            }
        }
        return results;
    }

    private void deleteVehicleMake(int id) {
        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(id);
        if (vehicleMake != null) {
            deleteVehicleModelsByMake(vehicleMake);
            vehicleMakeService.deleteVehicleMake(vehicleMake);
        }
    }

    private void deleteVehicleModelsByMake(VehicleMake vehicleMake) {
        List<VehicleModel> modelsToDelete = getVehicleModelsByMake(vehicleMake);
        for (int i = modelsToDelete.size() - 1; i >= 0; --i) {
            deleteVehiclesByModel(modelsToDelete.get(i));
            vehicleModelService.deleteVehicleModel(modelsToDelete.get(i));
        }
    }

    private void deleteVehiclesByModel(VehicleModel vehicleModel) {
        List<Vehicle> vehiclesToDelete = getVehiclesByModel(vehicleModel);
        for (int i = vehiclesToDelete.size() - 1; i >= 0; --i)
            vehicleService.deleteVehicle(vehiclesToDelete.get(i));
    }

    private void logVehicleMakeVo(VehicleMakeVo vehicleMakeVo) {
        log.info("New Vehicle Make: " + vehicleMakeVo.getNewVehicleMake());
        // regex for splitting on newline or carriage return is \\r?\\n
        String[] split = vehicleMakeVo.getNewVehicleModelArray();
        for (String splitStr : split) {
            log.info("New Vehicle Model: " + splitStr);
        }
    }

    private void saveVehicleMakeAndVehicleModelsFromVo(VehicleMakeVo vehicleMakeVo) {

        VehicleMake vehicleMake = new VehicleMake(vehicleMakeVo.getNewVehicleMake());

        List<VehicleModel> vehicleModels = new ArrayList<>();
        for (String str : vehicleMakeVo.getNewVehicleModelArray()) {
            VehicleModel vehicleModel = new VehicleModel(str);
            vehicleModel.setVehicleMake(vehicleMake);
            vehicleModels.add(vehicleModel);
        }
        vehicleMakeService.saveVehicleMake(vehicleMake);

        if (vehicleModels.size() > 0)
            vehicleModelService.saveVehicleModels(vehicleModels);
    }

    //endregion
}

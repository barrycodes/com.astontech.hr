package com.astontech.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by barrsmit1 on 6/16/2016.
 */
@Controller
public class TrainingController {

    @RequestMapping(value = "/admin/training", method = RequestMethod.GET)
    public String trainingGet(Model model) {
        return "/admin/training/training_list";
    }

    @RequestMapping(value = "/admin/training/list", method = RequestMethod.GET)
    public String trainingListGet(Model model) {
        return trainingGet(model);
    }

    @RequestMapping(value = "/admin/training/add", method = RequestMethod.GET)
    public String trainingAddGet(Model model) {
        return "redirect:/admin/training/add";
    }
}

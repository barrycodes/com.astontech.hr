package com.astontech.hr.controllers;

import com.astontech.hr.domain.Curriculum;
import com.astontech.hr.services.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by barrsmit1 on 6/16/2016.
 */
@Controller
public class TrainingController {

    @Autowired
    private CurriculumService curriculumService;

    @RequestMapping(value = "/admin/training", method = RequestMethod.GET)
    public String trainingGet(Model model) {

        model.addAttribute("curriculums", curriculumService.getAllCurriculums());

        return "/admin/training/training_list";
    }

    @RequestMapping(value = "/admin/training/list", method = RequestMethod.GET)
    public String trainingListGet(Model model) {
        return trainingGet(model);
    }

    @RequestMapping(value = "/admin/training/curriculum/add", method = RequestMethod.GET)
    public String trainingAddGet(Model model) {

        model.addAttribute("curriculum", new Curriculum());

        return "/admin/training/training_curriculum_add";
    }

    @RequestMapping(value = "/admin/training/curriculum/add", method = RequestMethod.POST)
    public String trainingAddPost(Curriculum curriculum, Model model) {

        curriculumService.saveCurriculum(curriculum);

        return "redirect:/admin/training";

    }
}

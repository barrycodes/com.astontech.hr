package com.astontech.hr.controllers;

import com.astontech.hr.domain.Curriculum;
import com.astontech.hr.domain.CurriculumCollection;
import com.astontech.hr.services.CurriculumCollectionService;
import com.astontech.hr.services.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by barrsmit1 on 6/16/2016.
 */
@Controller
public class TrainingController {

    @Autowired
    private CurriculumService curriculumService;

    @Autowired
    private CurriculumCollectionService curriculumCollectionService;

    @RequestMapping(value = "/admin/training", method = RequestMethod.GET)
    public String trainingGet(Model model) {

        model.addAttribute(
                "curriculums",
                curriculumCollectionService.getFirstCurriculumCollection().getCurriculums());

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

        CurriculumCollection cc = curriculumCollectionService.getFirstCurriculumCollection();
        cc.getCurriculums().add(curriculum);
        curriculumCollectionService.saveCurriculumCollection(cc);

        return "redirect:/admin/training";
    }

    @RequestMapping(value = "/admin/training/curriculum/up/{id}", method = RequestMethod.GET)
    public String trainingUpGet(@PathVariable("id") int id, Model model) {
        CurriculumCollection cc = curriculumCollectionService.getFirstCurriculumCollection();
        List<Curriculum> cList = cc.getCurriculums();
        Curriculum c = curriculumService.getCurriculumById(id);

        int index = cc.getCurriculums().indexOf(c);

        if (index > 0) {
            cList.remove(index);
            cList.add(index - 1, c);
        }

        curriculumCollectionService.saveCurriculumCollection(cc);
        return "redirect:/admin/training";
    }

    @RequestMapping(value = "/admin/training/curriculum/down/{id}", method = RequestMethod.GET)
    public String trainingDownGet(@PathVariable("id") int id, Model model) {
        CurriculumCollection cc = curriculumCollectionService.getFirstCurriculumCollection();
        List<Curriculum> cList = cc.getCurriculums();
        Curriculum c = curriculumService.getCurriculumById(id);

        int index = cc.getCurriculums().indexOf(c);

        if (index < (cList.size() - 1)) {
            cList.remove(index);
            cList.add(index + 1, c);
        }

        curriculumCollectionService.saveCurriculumCollection(cc);
        return "redirect:/admin/training";
    }

    @RequestMapping(value = "/admin/training/curriculum/delete/{id}", method = RequestMethod.GET)
    public String trainingDeleteGet(@PathVariable("id") int id, Model model) {
        CurriculumCollection cc = curriculumCollectionService.getFirstCurriculumCollection();
        List<Curriculum> cList = cc.getCurriculums();
        Curriculum c = curriculumService.getCurriculumById(id);

        cList.remove(c);

        curriculumCollectionService.saveCurriculumCollection(cc);
        curriculumService.deleteCurriculum(id);

        return "redirect:/admin/training";
    }
}

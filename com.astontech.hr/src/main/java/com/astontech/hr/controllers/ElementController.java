package com.astontech.hr.controllers;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.domain.vo.ElementVo;
import com.astontech.hr.services.ElementTypeService;
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
public class ElementController {
    @Autowired
    private ElementTypeService elementTypeService;

    private Logger log = Logger.getLogger(ElementController.class);

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.GET)
    public String adminElementGet(Model model) {
        model.addAttribute("elementVo", new ElementVo());
        model.addAttribute("warningAlert", "visible");
        return "/admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.POST)
    public String adminElementPost(ElementVo elementVo, Model model) {

        elementVo.splitNewElementsIntoArray();

        logElementVo(elementVo);

        saveElementTypeAndElementsFromVo(elementVo);
        boolean success = true;
        if (success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        model.addAttribute("elementVo", new ElementVo());

        return "/admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element", method = RequestMethod.GET)
    public String adminElementsGet(Model model) {
        return adminElementListGet(model);
    }

    @RequestMapping(value = "/admin/element/list", method = RequestMethod.GET)
    public String adminElementListGet(Model model) {
        model.addAttribute(elementTypeService.listAllElementTypes());
        return "/admin/element/element_list";
    }

    @RequestMapping(value = "/admin/element/edit/{id}", method = RequestMethod.GET)
    public String elementTypeEditGet(@PathVariable int id, Model model) {
        ElementType elementType = elementTypeService.getElementTypeById(id);
        model.addAttribute("elementType", elementType);
        return "/admin/element/element_edit";
    }

    @RequestMapping(value = "/admin/element/update", method = RequestMethod.POST)
    public String elementTypeUpdatePost(ElementType elementType,
                                        Model model,
                                        @RequestParam("inputNewElement") String newElement) {

        if (!newElement.equals("")) {
            if (elementType.getElements() == null) {
                List<Element> elements = new ArrayList<>();
                elements.add(new Element(newElement));
                elementType.setElements(elements);
            } else {
                elementType.getElements().add(new Element(newElement));
            }
        }
        for (int i = 0; i < elementType.getElements().size(); ++i) {
            String eName = elementType.getElements().get(i).getElementName();
            if (eName == null || eName.equals(""))
                elementType.getElements().remove(i);
        }
        elementTypeService.saveElementType(elementType);
        model.addAttribute("successAlert", "visible");

        return "redirect:/admin/element/edit/" + elementType.getId();
    }

    @RequestMapping(value = "/admin/element/delete/{id}", method = RequestMethod.GET)
    public String elementTypeDelete(@PathVariable int id) {
        elementTypeService.deleteElementType(id);
        return "redirect:/admin/element/list";
    }

    //region HELPER METHODS

    private void logElementVo(ElementVo elementVo) {
        log.info("New Element Type: " + elementVo.getNewElementType());
        // regex for splitting on newline or carriage return is \\r?\\n
        String[] split = elementVo.getNewElementArray();
        for (String splitStr : split) {
            log.info("New Element: " + splitStr);
        }
    }

    private String[] splitElements(String str) {
        return str.split("\\r?\\n");
    }

    private void saveElementTypeAndElementsFromVo(ElementVo elementVo) {
        List<Element> newElementList = new ArrayList<>();
        for (String str : elementVo.getNewElementArray()) {
            newElementList.add(new Element(str));
        }
        ElementType newElementType = new ElementType(elementVo.getNewElementType());
        newElementType.setElements(newElementList);

        elementTypeService.saveElementType(newElementType);
    }

    //endregion
}

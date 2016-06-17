package com.astontech.hr.controllers;

import com.astontech.hr.domain.Simple;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by barrsmit1 on 6/13/2016.
 */
@RestController
public class SimpleController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/simple")
    public HttpEntity<Simple> simple(
            @RequestParam(value="name", required = false, defaultValue = "World") String name) {

        Simple mySimple = new Simple(String.format(TEMPLATE, name));

        mySimple.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(SimpleController.class).simple(name)).withSelfRel());

        return new ResponseEntity<Simple>(mySimple, HttpStatus.OK);
    }

}

package com.astontech.hr.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by barrsmit1 on 6/13/2016.
 */
public class Simple extends ResourceSupport {

    private final String myContent;

    @JsonCreator
    public Simple(@JsonProperty("myContent") String myContent) {
        this.myContent = myContent;
    }

    public String getMyContent() {
        return myContent;
    }
}

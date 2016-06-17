package com.astontech.hr.domain;

import javax.persistence.Entity;

/**
 * Created by barrsmit1 on 6/16/2016.
 */
@Entity
public class ExerciseAssignment extends Assignment {

    public ExerciseAssignment() {
        this(null);
    }

    public ExerciseAssignment(String name) {
        super(name, true);
    }

}

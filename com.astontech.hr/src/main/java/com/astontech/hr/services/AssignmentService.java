package com.astontech.hr.services;

import com.astontech.hr.domain.Assignment;
import com.astontech.hr.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by barrsmit1 on 6/16/2016.
 */
public interface AssignmentService {

    public Assignment getAssignmentById(int id);

    public Iterable<Assignment> getAllAssignments();

    public Assignment saveAssignment(Assignment a);

    public void deleteAssignment(int id);

    public void deleteAllAssignments();

}

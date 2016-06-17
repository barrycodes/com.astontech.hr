package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Assignment;
import com.astontech.hr.repositories.AssignmentRepository;
import com.astontech.hr.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by barrsmit1 on 6/16/2016.
 */
@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository repository;

    @Override
    public Assignment getAssignmentById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<Assignment> getAllAssignments() {
        return repository.findAll();
    }

    @Override
    public Assignment saveAssignment(Assignment a) {
        return repository.save(a);
    }

    @Override
    public void deleteAssignment(int id) {
        repository.delete(id);
    }

    @Override
    public void deleteAllAssignments() {
        repository.deleteAll();
    }
}

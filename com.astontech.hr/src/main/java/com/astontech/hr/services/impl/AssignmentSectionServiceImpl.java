package com.astontech.hr.services.impl;

import com.astontech.hr.domain.AssignmentSection;
import com.astontech.hr.repositories.AssignmentSectionRepository;
import com.astontech.hr.services.AssignmentSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by barrsmit1 on 6/16/2016.
 */
@Service
public class AssignmentSectionServiceImpl implements AssignmentSectionService {

    @Autowired
    private AssignmentSectionRepository repository;

    @Override
    public AssignmentSection getAssignmentSectionById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<AssignmentSection> getAllAssignmentSections() {
        return repository.findAll();
    }

    @Override
    public AssignmentSection saveAssignmentSection(AssignmentSection s) {
        return repository.save(s);
    }

    @Override
    public void deleteAssignmentSection(int id) {
        repository.delete(id);
    }

    @Override
    public void deleteAllAssignmentSections() {
        repository.deleteAll();
    }
}

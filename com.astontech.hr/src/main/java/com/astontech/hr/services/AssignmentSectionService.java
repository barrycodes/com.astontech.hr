package com.astontech.hr.services;

import com.astontech.hr.domain.AssignmentSection;

/**
 * Created by barrsmit1 on 6/15/2016.
 */
public interface AssignmentSectionService {

    public AssignmentSection getAssignmentSectionById(int id);

    public Iterable<AssignmentSection> getAllAssignmentSections();

    public AssignmentSection saveAssignmentSection(AssignmentSection s);

    public void deleteAssignmentSection(int id);

    public void deleteAllAssignmentSections();

}

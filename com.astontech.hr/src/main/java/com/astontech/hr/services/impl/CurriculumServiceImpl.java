package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Curriculum;
import com.astontech.hr.repositories.CurriculumRepository;
import com.astontech.hr.services.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by barrsmit1 on 6/15/2016.
 */
@Service
public class CurriculumServiceImpl implements CurriculumService {

    @Autowired
    private CurriculumRepository curriculumRepository;

    @Override
    public Curriculum getCurriculumById(int id) {
        return curriculumRepository.findOne(id);
    }

    @Override
    public Iterable<Curriculum> getAllCurriculums() {
        return curriculumRepository.findAll();
    }

    @Override
    public void deleteCurriculum(int id) {
        curriculumRepository.delete(id);
    }

    @Override
    public void deleteAllCurriculums() {
        curriculumRepository.deleteAll();
    }

    @Override
    public Curriculum saveCurriculum(Curriculum c) {
        return curriculumRepository.save(c);
    }
}

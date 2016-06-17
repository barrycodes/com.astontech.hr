package com.astontech.hr.services;

import com.astontech.hr.domain.Curriculum;

/**
 * Created by barrsmit1 on 6/15/2016.
 */
public interface CurriculumService {

    public Curriculum getCurriculumById(int id);

    public Iterable<Curriculum> getAllCurriculums();

    public void deleteCurriculum(int id);

    public void deleteAllCurriculums();

    public Curriculum saveCurriculum(Curriculum c);

}

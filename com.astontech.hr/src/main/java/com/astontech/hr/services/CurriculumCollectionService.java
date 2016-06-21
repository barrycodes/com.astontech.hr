package com.astontech.hr.services;

import com.astontech.hr.domain.CurriculumCollection;

/**
 * Created by barrsmit1 on 6/21/2016.
 */
public interface CurriculumCollectionService {

    public CurriculumCollection getCurriculumCollectionById(int id);

    public Iterable<CurriculumCollection> getAllCurriculumCollections();

    public CurriculumCollection saveCurriculumCollection(CurriculumCollection c);

    public void deleteCurriculumCollection(int id);

    public void deleteAllCurriculumCollections();

    public CurriculumCollection getFirstCurriculumCollection();

}

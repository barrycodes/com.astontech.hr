package com.astontech.hr.services.impl;

import com.astontech.hr.domain.CurriculumCollection;
import com.astontech.hr.repositories.CurriculumCollectionRepository;
import com.astontech.hr.services.CurriculumCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by barrsmit1 on 6/21/2016.
 */
@Service
public class CurriculumCollectionServiceImpl implements CurriculumCollectionService {

    @Autowired
    private CurriculumCollectionRepository repository;

    @Override
    public CurriculumCollection getCurriculumCollectionById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<CurriculumCollection> getAllCurriculumCollections() {
        return repository.findAll();
    }

    @Override
    public CurriculumCollection saveCurriculumCollection(CurriculumCollection c) {
        return repository.save(c);
    }

    @Override
    public void deleteCurriculumCollection(int id) {
        repository.delete(id);
    }

    @Override
    public void deleteAllCurriculumCollections() {
        repository.deleteAll();
    }

    @Override
    public CurriculumCollection getFirstCurriculumCollection() {
        Iterable<CurriculumCollection> cCollection = repository.findAll();
        CurriculumCollection result = null;
        for (CurriculumCollection c : cCollection) {
            result = c;
            break;
        }
        return result;
    }
}

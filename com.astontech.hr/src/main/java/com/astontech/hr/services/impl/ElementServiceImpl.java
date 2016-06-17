package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.services.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by barrsmit1 on 6/3/2016.
 */
@Service
public class ElementServiceImpl implements ElementService {

    @Autowired
    private ElementRepository elementRepository;

    @Override
    public Iterable<Element> listAllElements() {
        return elementRepository.findAll();
    }

    @Override
    public Element getElementById(Integer id) {
        return elementRepository.findOne(id);
    }

    @Override
    public Element saveElement(Element element) {
        return elementRepository.save(element);
    }

    @Override
    public Iterable<Element> saveElementList(Iterable<Element> elements) {
        return elementRepository.save(elements);
    }

    @Override
    public void deleteElement(Integer id) {
        elementRepository.delete(id);
    }

    @Override
    public void deleteAllElements() {
        elementRepository.deleteAll();
    }

    @Override
    public Element findByElementName(String elementName) {
        return elementRepository.findByElementName(elementName);
    }

    @Override
    public List<Element> findAllByElementName(String elementName) {
        return elementRepository.findAllByElementName(elementName);
    }

    @Override
    public int deleteAllByElementName(String elementName) {
        return deleteAllByElementName(elementName);
    }

    @Override
    public List<String> findDistinctByElementName(String elementName) {
        return elementRepository.findDistinctByElementName(elementName);
    }

    @Override
    public Element findTopByOrderByElementNameDesc() {
        return elementRepository.findTopByOrderByElementNameDesc();
    }

    @Override
    public Element findTopByOrderByElementName() {
        return elementRepository.findTopByOrderByElementName();
    }

    @Override
    public List<Element> findTop2ByOrderByElementName() {
        return elementRepository.findTop2ByOrderByElementName();
    }

    @Override
    public int countByElementName(String elementName) {
        return elementRepository.countByElementName(elementName);
    }

    @Override
    public List<Element> findAllByElementNameIgnoreCase(String elementName) {
        return elementRepository.findAllByElementNameIgnoreCase(elementName);
    }
}

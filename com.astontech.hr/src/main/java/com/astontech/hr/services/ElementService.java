package com.astontech.hr.services;

import com.astontech.hr.domain.Element;

import java.util.List;

/**
 * Created by barrsmit1 on 6/3/2016.
 */
public interface ElementService {

    Iterable<Element> listAllElements();

    Element getElementById(Integer id);

    Element saveElement(Element element);

    Iterable<Element> saveElementList(Iterable<Element> elements);

    void deleteElement(Integer id);

    void deleteAllElements();

    // causes method implementation to be auto-generated
    Element findByElementName(String elementName);

    List<Element> findAllByElementName(String elementName);

    int deleteAllByElementName(String elementName);

    List<String> findDistinctByElementName(String elementName);

    Element findTopByOrderByElementNameDesc();

    Element findTopByOrderByElementName();

    List<Element> findTop2ByOrderByElementName();

    int countByElementName(String elementName);

    List<Element> findAllByElementNameIgnoreCase(String elementName);
}

package com.astontech.hr.services;

import com.astontech.hr.domain.ElementType;

/**
 * Created by barrsmit1 on 6/3/2016.
 */
public interface ElementTypeService {

    Iterable<ElementType> listAllElementTypes();

    ElementType getElementTypeById(Integer id);

    ElementType saveElementType(ElementType elementType);

    Iterable<ElementType> saveElementTypes(Iterable<ElementType> elementTypes);

    void deleteElementType(Integer id);

    void deleteAllElementTypes();

    ElementType findByElementTypeName(String elementTypeName);

}

package com.astontech.hr.repositories;

import com.astontech.hr.domain.ElementType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by barrsmit1 on 6/2/2016.
 */
public interface ElementTypeRepository extends CrudRepository<ElementType, Integer> {
    ElementType findByElementTypeName(String elementTypeName);
}

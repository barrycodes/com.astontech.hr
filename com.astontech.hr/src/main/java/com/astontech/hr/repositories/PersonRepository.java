package com.astontech.hr.repositories;

import com.astontech.hr.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by barrsmit1 on 6/14/2016.
 */
@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, Integer> {
}

package com.astontech.hr.repositories;

import com.astontech.hr.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by barrsmit1 on 6/13/2016.
 */
@RepositoryRestResource
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
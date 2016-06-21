package com.astontech.hr.repositories;

import com.astontech.hr.domain.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by barrsmit1 on 6/20/2016.
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {
}

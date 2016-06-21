package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Student;
import com.astontech.hr.repositories.StudentRepository;
import com.astontech.hr.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by barrsmit1 on 6/20/2016.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student getStudentById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student s) {
        return repository.save(s);
    }

    @Override
    public void deleteStudent(int id) {
        repository.delete(id);
    }

    @Override
    public void deleteAllStudents() {
        repository.deleteAll();
    }
}

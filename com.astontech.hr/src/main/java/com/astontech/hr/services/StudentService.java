package com.astontech.hr.services;

import com.astontech.hr.domain.Student;

/**
 * Created by barrsmit1 on 6/20/2016.
 */
public interface StudentService {

    public Student getStudentById(int id);

    public Iterable<Student> getAllStudents();

    public Student saveStudent(Student s);

    public void deleteStudent(int id);

    public void deleteAllStudents();

}

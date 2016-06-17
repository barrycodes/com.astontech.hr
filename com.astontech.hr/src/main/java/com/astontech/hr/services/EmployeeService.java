package com.astontech.hr.services;

import com.astontech.hr.domain.Employee;
import com.astontech.hr.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by barrsmit1 on 6/13/2016.
 */
public interface EmployeeService {

    public Employee getEmployeeById(Integer id);

    public Iterable<Employee> getAllEmployees();

    public Employee getEmployeeById(int id);

    public Employee saveEmployee(Employee employee);

    public void deleteAllEmployees();

    public void deleteEmployee(int id);

}

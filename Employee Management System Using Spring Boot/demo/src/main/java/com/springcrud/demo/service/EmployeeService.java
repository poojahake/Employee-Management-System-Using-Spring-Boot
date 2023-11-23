package com.springcrud.demo.service;

import java.util.List;

import com.springcrud.demo.model.Employee;

public interface EmployeeService {

    
    public Employee AddORUpdate(Employee emp);

    public List<Employee> getAll();

    public Employee getbyID(int id);    

    public Employee delete(int id) throws Exception;

    public Employee update(int id,Employee myResource) throws Exception;
}

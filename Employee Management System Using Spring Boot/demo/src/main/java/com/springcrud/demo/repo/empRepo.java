package com.springcrud.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.springcrud.demo.model.Employee;


public interface empRepo extends CrudRepository<Employee, Integer>{
    
}

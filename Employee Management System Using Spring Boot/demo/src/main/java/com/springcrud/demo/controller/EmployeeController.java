package com.springcrud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.springcrud.demo.model.Employee;
import com.springcrud.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService empService;

    @PostMapping("AddORUpdate")
    public ResponseEntity<Employee> AddORUpdate(@RequestBody Employee empl){
        Employee emp = null;
        try{
            emp=empService.AddORUpdate(empl);
        }catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    @GetMapping("allEmp")
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> emp = null;
        try{
            emp=empService.getAll();
        }catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
    }

    @GetMapping("getbyId/{id}")
    public ResponseEntity<Employee> getbyID(@PathVariable("id") int id){
        Employee emp = null;
        try{
            emp=empService.getbyID(id);
        }catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable("id") int id) {
        Employee emp = null;
        try{
            emp=empService.delete(id);
        }catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") int id,@RequestBody Employee myResource) {
        Employee emp = null;
        try{
            emp=empService.update(id,myResource);
        }catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }
}

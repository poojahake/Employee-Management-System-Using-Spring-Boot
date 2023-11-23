package com.springcrud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcrud.demo.model.Employee;
import com.springcrud.demo.repo.empRepo;

@Service
public class EmployeeImpl implements EmployeeService{
    @Autowired
    private empRepo eRepo;

    @Override
    public Employee AddORUpdate(Employee emp) {     
       
       return eRepo.save(emp);
    }


    @Override
    public List<Employee> getAll() {        
        
        return (List<Employee>) eRepo.findAll();
    }

    @Override
    public Employee getbyID(int id) {      
       
        return eRepo.findById(id).orElse(null);
    }

    @Override
    public Employee delete(int id) throws Exception{        
      
       Employee deletedEmp=null;
       try{
        deletedEmp=eRepo.findById(id).orElse(null);
        if(deletedEmp == null){
            throw new Exception("user not available");
        }else{
            eRepo.deleteById(id);
        }
       }catch(Exception ex){
        System.out.println(ex.getMessage());
        throw ex;
       }        
       return deletedEmp;
    }
    

    @Override
    public Employee update(int id,Employee myResource) throws Exception{        
      
       Employee updateEmp=eRepo.findById(id).orElse(null);
       try{
        if(updateEmp == null){
            throw new Exception("user not available");
        }else{
            updateEmp.setName(myResource.getName());
            updateEmp.setAge(myResource.getAge());
            updateEmp.setSalary(myResource.getSalary());
            System.out.println("chetan" + myResource.getName());

            updateEmp = eRepo.save(updateEmp);
            return updateEmp;
        }
       }catch(Exception ex){
        System.out.println(ex.getMessage());
        throw ex;
       }        
    //    return updateEmp;
    }

}

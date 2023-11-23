package com.springcrud.demo.model;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_demo2")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  //default auto incremented primary key generation
    private int id;
    private String name;
    private int age;
    private float salary;
 
    public Employee() {
    }

    public Employee(int id, String name, int age, float salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    //represent an object of a class as a String to avoid hashcode ->  eg.Employee@1fee6fc
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }
    
    
}

package com.example.model;

public class Employee {
    private int id;
    private String name;
    private double salary;
    public Employee(int id, String name){
        if(id>0){
            this.id=id;
        }
        if(name!=null){
            this.name=name;
        }
    }
    // get / set
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}

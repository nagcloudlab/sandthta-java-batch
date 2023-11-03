package com.example;

import com.example.model.DevEmployee;

public class Application {
    public static void main(String[] args) {

        DevEmployee devEmployee=new DevEmployee(101,"John");
        devEmployee.setSalary(100.00);
        devEmployee.setDevSkills("java,spring");

        System.out.println(devEmployee.getName()+","+devEmployee.getSalary());



    }
}

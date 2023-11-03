package com.example.model;

public class DevEmployee extends Employee {
    private String devSkills;
    public DevEmployee(int id, String name){
        super(id, name);
    }

    public String getDevSkills() {
        return devSkills;
    }

    public void setDevSkills(String devSkills) {
        this.devSkills = devSkills;
    }
}

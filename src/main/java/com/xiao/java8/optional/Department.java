package com.xiao.java8.optional;

public class Department {
    private Employee employee;
    public Department(Employee employee) {
        this.employee = employee;
    }
    Employee getEmployee() {
        return employee;
    }
}

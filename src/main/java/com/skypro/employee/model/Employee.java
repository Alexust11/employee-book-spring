package com.skypro.employee.model;

import org.apache.commons.lang3.StringUtils;

public class Employee {
    private static int counter;
    private final int id;
    private final String name;
    private final String surName;
    private final String departament;
    private final int salary;

    public Employee(String name, String surName, String departament, int salary) {
        this.name = name;
               this.surName = surName;
        this.departament = departament;
        this.salary = salary;
        this.id=counter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getDepartament() {
        return departament;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", departament='" + departament + '\'' +
                ", salary=" + salary +
                '}';
    }
}

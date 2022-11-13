package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees=new HashMap<>();



    public Collection<Employee> getAllEmployees () {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getName() == null || employeeRequest.getSurName() == null) {
            throw new IllegalArgumentException("Не ввели имя или фамилию");
        }
        Employee employee=new Employee(employeeRequest.getName(), employeeRequest.getSurName(), employeeRequest.getDepartament(),employeeRequest.getSalary());
        this.employees.put(employee.getId(), employee);
        return employee;
    }
}

package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
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
    public int getSalarySum() {
     return 0;
    }

    public int getSalareSum() {
        return employees.values().stream().mapToInt(Employee::getSalary).sum();
    }

    public String getMinSalary() {
        return employees.values().stream().min(Comparator.comparingInt(Employee::getSalary)).get().getSurName();
    }

    public String getMaxSalary() {
        return employees.values().stream().max(Comparator.comparingInt(Employee::getSalary)).get().getSurName();
    }
}

package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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


    public int getSalareSum() {
        return employees.values().stream().mapToInt(Employee::getSalary).sum();
    }

    public Employee getMinSalary() {
        return employees.values().stream().min(Comparator.comparingInt(Employee::getSalary)).get();
    }

    public Employee getMaxSalary() {
        return employees.values().stream().max(Comparator.comparingInt(Employee::getSalary)).get();
    }

    public List<String>  getEmployeesSred() {
         double sr=employees.values().stream().mapToInt(Employee->Employee.getSalary()).average().orElse(0);
          return  employees.values().stream().filter(x->x.getSalary()>sr).map(x->x.getSurName()).collect(Collectors.toList());

    }

    public List<Employee> getEmployeesSred1() {
        double sr=employees.values().stream().mapToInt(Employee->Employee.getSalary()).average().orElse(0);
        return employees.values().stream().filter(x->x.getSalary()>sr).collect(Collectors.toList());

    }
}

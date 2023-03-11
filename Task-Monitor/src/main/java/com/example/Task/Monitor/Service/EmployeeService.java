package com.example.Task.Monitor.Service;

import com.example.Task.Monitor.Model.Employee;
import com.example.Task.Monitor.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee, UUID id) {
        Employee myEmployee = employeeRepository.findByEmployeeId(id);
        myEmployee.setName(employee.getName());
        myEmployee.setEmail(employee.getEmail());
        myEmployee.setPhone(employee.getPhone());
        myEmployee.setBirthDate(employee.getBirthDate());
        myEmployee.setSalary(employee.getSalary());
        employeeRepository.save(myEmployee);
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteByEmployeeId(id);
    }

    public List<Employee> bestFiveEmployees (List<UUID> id) {
        List<Employee> bestFiveEmployees = new ArrayList<>();
        for (var el : id) {
            bestFiveEmployees.add(employeeRepository.findByEmployeeId(el));
        }
        return bestFiveEmployees;
    }

}

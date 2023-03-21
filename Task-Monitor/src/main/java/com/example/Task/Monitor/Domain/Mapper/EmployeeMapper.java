package com.example.Task.Monitor.Domain.Mapper;

import com.example.Task.Monitor.Domain.Dtos.EmployeeDTO;
import com.example.Task.Monitor.Domain.Entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee employeeDtoToEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setPhone(dto.getPhone());
        employee.setEmail(dto.getEmail());
        employee.setBirthDate(dto.getBirthDate());
        employee.setSalary(dto.getSalary());
        return employee;
    }

    public EmployeeDTO employeeEntityToDto(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setName(employee.getName());
        dto.setPhone(employee.getPhone());
        dto.setEmail(employee.getEmail());
        dto.setBirthDate(employee.getBirthDate());
        dto.setSalary(employee.getSalary());
        return dto;
    }
}

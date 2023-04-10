package com.example.Task.Monitor.Domain.Service;

import com.example.Task.Monitor.Domain.Dtos.EmployeeDTO;
import com.example.Task.Monitor.Domain.Entity.Employee;
import com.example.Task.Monitor.Domain.Mapper.EmployeeMapper;
import com.example.Task.Monitor.Exceptions.EmailAlreadyExistsException;
import com.example.Task.Monitor.Exceptions.NoIdExistsException;
import com.example.Task.Monitor.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> allEmployee = employeeRepository.findAll();
        List<EmployeeDTO> allEmployeeDto = new ArrayList<>();
        for (var employee : allEmployee) {
            allEmployeeDto.add(employeeMapper.employeeEntityToDto(employee));
        }

        return allEmployeeDto;
    }

    public void createEmployee(EmployeeDTO employeeDto) {
        if (employeeRepository.findByEmail(employeeDto.getEmail()) != null) {
            throw new EmailAlreadyExistsException();
        }
        Employee employee = Employee.builder()
                .name(employeeDto.getName())
                .email(employeeDto.getEmail())
                .phone(employeeDto.getPhone())
                .birthDate(employeeDto.getBirthDate())
                .salary(employeeDto.getSalary())
                .build();
        //Employee employee = employeeMapper.employeeDtoToEntity(employeeDto);
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee, UUID id) {
        if (employeeRepository.findByEmployeeId(id) == null) {
            throw new NoIdExistsException();
        }
        Employee myEmployee = employeeRepository.findByEmployeeId(id);
        myEmployee.setName(employee.getName());
        myEmployee.setEmail(employee.getEmail());
        myEmployee.setPhone(employee.getPhone());
        myEmployee.setBirthDate(employee.getBirthDate());
        myEmployee.setSalary(employee.getSalary());
        employeeRepository.save(myEmployee);
    }

    public void deleteEmployee(UUID id) {
        if (employeeRepository.findByEmployeeId(id) == null) {
            throw new NoIdExistsException();
        }
        employeeRepository.deleteByEmployeeId(id);
    }

    public List<Employee> findEmployeesByIdList(List<UUID> id) {
        List<Employee> foundedEmployees = new ArrayList<>();
        for (var el : id) {
            foundedEmployees.add(employeeRepository.findByEmployeeId(el));
        }
        return foundedEmployees;
    }

}

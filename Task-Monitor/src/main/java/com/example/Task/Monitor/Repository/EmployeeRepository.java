package com.example.Task.Monitor.Repository;

import com.example.Task.Monitor.Domain.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {


    Employee findByEmployeeId(UUID id);

    Employee findByEmail(String email);

    @Transactional
    void deleteByEmployeeId(UUID id);

}

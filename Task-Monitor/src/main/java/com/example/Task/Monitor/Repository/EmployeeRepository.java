package com.example.Task.Monitor.Repository;

import com.example.Task.Monitor.Model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {


    Employee findByEmployeeId(UUID id);

    @Transactional
    void deleteByEmployeeId(UUID id);

}

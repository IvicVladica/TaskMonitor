package com.example.Task.Monitor.Repository;

import com.example.Task.Monitor.Model.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;


public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findByTaskId(UUID id);

    @Transactional
    void deleteByTaskId(UUID id);

    @Query(value = "SELECT assignee FROM tasks " +
            "WHERE due_date >= date_trunc('month', current_date - interval '1' month)\n" +
            "AND due_date < date_trunc('month', current_date)" +
            "GROUP BY assignee ORDER BY COUNT(*) DESC LIMIT 5", nativeQuery = true)
    List<UUID> findFiveBestEmployeeId();


}

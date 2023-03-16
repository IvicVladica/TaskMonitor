package com.example.Task.Monitor.Repository;

import com.example.Task.Monitor.Domain.Entity.Task;
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
            "WHERE due_date > (CURRENT_DATE - INTERVAL '3' MONTH)\n" +
            "AND due_date <= (CURRENT_DATE)" +
            "GROUP BY assignee ORDER BY COUNT(*) DESC LIMIT 5", nativeQuery = true)
    List<UUID> findFiveBestEmployeeId();

    @Query(value = "SELECT client FROM tasks " +
            "WHERE due_date > (current_date - interval '3' month)\n" +
            "AND due_date <= (current_date)" +
            "GROUP BY client ORDER BY COUNT(*) DESC LIMIT 3", nativeQuery = true)
    List<UUID> findThreeTopClientId();

    @Query(value = "SELECT client FROM tasks " +
            "WHERE due_date > (current_date - interval '3' month)\n" +
            "AND due_date <= (current_date)" +
            "GROUP BY client ORDER BY COUNT(*) ASC LIMIT 3", nativeQuery = true)
    List<UUID> findThreeWorstClientId();

    Integer countByClient(UUID id);

}

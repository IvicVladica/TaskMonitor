package com.example.Task.Monitor.Repository;

import com.example.Task.Monitor.Model.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findByTaskId(Integer id);

    @Transactional
    void deleteByTaskId(Integer id);

}

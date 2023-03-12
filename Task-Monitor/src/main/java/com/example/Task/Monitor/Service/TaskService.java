package com.example.Task.Monitor.Service;

import com.example.Task.Monitor.Model.Task;
import com.example.Task.Monitor.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    public TaskRepository taskRepository;

    @Autowired
    public TaskService (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(Task task) {taskRepository.save(task);}

    public void updateTask(Task task, UUID id) {
        Task myTask = taskRepository.findByTaskId(id);
        myTask.setTitle(task.getTitle());
        myTask.setDescription(task.getDescription());
        myTask.setAssignee(task.getAssignee());
        myTask.setClient(task.getClient());
        myTask.setDate(task.getDate());
        taskRepository.save(myTask);
    }

    public void deleteTask(UUID id) {
        taskRepository.deleteByTaskId(id);
    }

    public List<UUID> bestFiveEmployeeId() {
        return taskRepository.findFiveBestEmployeeId();
    }

    public List<UUID> topThreeClientId() { return taskRepository.findThreeTopClientId();}

    public List<UUID> worstThreeClientId() { return taskRepository.findThreeWorstClientId();}

    public Integer countClients(UUID id) {return taskRepository.countByClient(id);}

}

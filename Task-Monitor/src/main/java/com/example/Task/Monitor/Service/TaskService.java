package com.example.Task.Monitor.Service;

import com.example.Task.Monitor.Model.Task;
import com.example.Task.Monitor.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(Task task, Integer id) {
        Task myTask = taskRepository.findByTaskId(id);
        myTask.setTitle(task.getTitle());
        myTask.setDescription(task.getDescription());
        myTask.setAssignee(task.getAssignee());
        myTask.setDate(task.getDate());
        taskRepository.save(myTask);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteByTaskId(id);
    }
}

package com.example.Task.Monitor.Controller;

import com.example.Task.Monitor.Model.Client;
import com.example.Task.Monitor.Model.Employee;
import com.example.Task.Monitor.Model.Task;
import com.example.Task.Monitor.Service.ClientService;
import com.example.Task.Monitor.Service.EmployeeService;
import com.example.Task.Monitor.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class Controller {

    private EmployeeService employeeService;
    private TaskService taskService;
    private ClientService clientService;


    @Autowired
    public Controller (EmployeeService employeeService, TaskService taskService, ClientService clientService) {
        this.employeeService = employeeService;
        this.taskService = taskService;
        this.clientService = clientService;
    }

    @GetMapping("/api/employees")
    public List<Employee> listAllEmployee() {return employeeService.getAllEmployees();}

    @PostMapping("api/employees/create")
    public void insertEmployee(@RequestBody Employee employee) {employeeService.createEmployee(employee);}

    @PatchMapping("api/employees/update/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable UUID id) {
        employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("api/employees/delete/{id}")
    public void deleteEmployee(@PathVariable UUID id) {employeeService.deleteEmployee(id);}

    @GetMapping("/api/tasks")
    public List<Task> listAllTasks() {return taskService.getAllTasks();}

    @PostMapping("api/tasks/create")
    public void insertTask(@RequestBody Task task) {taskService.createTask(task);}

    @PatchMapping("api/tasks/update/{id}")
    public void updateTask(@RequestBody Task task, @PathVariable UUID id) {
        taskService.updateTask(task, id);
    }

    @DeleteMapping("api/tasks/delete/{id}")
    public void deleteTask(@PathVariable UUID id) {taskService.deleteTask(id);}

    @GetMapping("api/tasks/bestfive")
    public List<Employee> bestFive() {
        List<UUID> bestFiveEmployeeId = taskService.bestFiveEmployeeId();
        return employeeService.bestFiveEmployees(bestFiveEmployeeId);
        }

    @GetMapping("api/clients")
    public List<Client> listAllClients() {return clientService.getAllClients();}

    @PostMapping("api/clients/create")
    public void insertClient(@RequestBody Client client) {clientService.createClient(client);}

    @PatchMapping("api/clients/update/{id}")
    public void updateClient(@RequestBody Client client, @PathVariable UUID id) {
        clientService.updateClient(client, id);}

    @DeleteMapping("api/clients/delete/{id}")
    public void deleteClient(@PathVariable UUID id) {clientService.deleteClient(id);}
}

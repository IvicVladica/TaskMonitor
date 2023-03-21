package com.example.Task.Monitor.Controller;

import com.example.Task.Monitor.Domain.Dtos.ClientDTO;
import com.example.Task.Monitor.Domain.Dtos.EmployeeDTO;
import com.example.Task.Monitor.Domain.Entity.Client;
import com.example.Task.Monitor.Domain.Entity.Employee;
import com.example.Task.Monitor.Domain.Entity.Task;
import com.example.Task.Monitor.Domain.Service.ClientService;
import com.example.Task.Monitor.Domain.Service.EmployeeService;
import com.example.Task.Monitor.Domain.Service.TaskService;
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
    public Controller(EmployeeService employeeService, TaskService taskService, ClientService clientService) {
        this.employeeService = employeeService;
        this.taskService = taskService;
        this.clientService = clientService;
    }

    @GetMapping("/api/employees")
    public List<EmployeeDTO> listAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("api/employees/create")
    public void insertEmployee(@RequestBody EmployeeDTO employeeDto) {
        employeeService.createEmployee(employeeDto);
    }

    @PatchMapping("api/employees/update/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable UUID id) {
        employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("api/employees/delete/{id}")
    public void deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/api/tasks")
    public List<Task> listAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("api/tasks/create")
    public void insertTask(@RequestBody Task task) {
        taskService.createTask(task);
        int clientCount = taskService.countClients(task.getClient());
        clientService.updateClientPriority(task.getClient(), clientCount);
    }

    @PatchMapping("api/tasks/update/{id}")
    public void updateTask(@RequestBody Task task, @PathVariable UUID id) {
        taskService.updateTask(task, id);
    }

    @DeleteMapping("api/tasks/delete/{id}")
    public void deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
    }

    @GetMapping("api/tasks/best5")
    public List<Employee> bestFiveEmployees() {
        List<UUID> bestFiveEmployeeId = taskService.bestFiveEmployeeId();
        return employeeService.findEmployeesByIdList(bestFiveEmployeeId);
    }

    @GetMapping("api/clients")
    public List<ClientDTO> listAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping("api/clients/create")
    public void insertClient(@RequestBody ClientDTO clientDto) {
        clientService.createClient(clientDto);
    }

    @PatchMapping("api/clients/update/{id}")
    public void updateClient(@RequestBody Client client, @PathVariable UUID id) {
        clientService.updateClient(client, id);
    }

    @DeleteMapping("api/clients/delete/{id}")
    public void deleteClient(@PathVariable UUID id) {
        clientService.deleteClient(id);
    }

    @GetMapping("api/tasks/top3")
    public List<Client> topThreeClients() {
        List<UUID> topThreeClientsId = taskService.topThreeClientId();
        return clientService.findClientsByIdList(topThreeClientsId);
    }

    @GetMapping("api/tasks/worst3")
    public List<Client> worstThreeClients() {
        List<UUID> worstThreeClientsId = taskService.worstThreeClientId();
        return clientService.findClientsByIdList(worstThreeClientsId);
    }

}

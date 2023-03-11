package com.example.Task.Monitor.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @Column(name="task_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID taskId;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="assignee")    //employeeId
    private UUID assignee;

    @Column(name = "client")  //clientId
    private UUID client;

    @Column(name="due_date")
    private LocalDate date;

}

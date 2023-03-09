package com.example.Task.Monitor.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private int taskId;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="assignee")
    private UUID assignee;

    @Column(name="due_date")
    private LocalDate date;

}

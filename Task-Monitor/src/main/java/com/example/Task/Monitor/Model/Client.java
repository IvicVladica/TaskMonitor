package com.example.Task.Monitor.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "clients")

public class Client {

    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    UUID clientId;

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @Column(name = "phone")
    String phone;

    @Column(name = "priority")
    String priority;

}

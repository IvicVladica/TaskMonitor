package com.example.Task.Monitor.Domain.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ClientDTO {

    private String name;

    private String address;

    private String phone;

    private String priority;

}

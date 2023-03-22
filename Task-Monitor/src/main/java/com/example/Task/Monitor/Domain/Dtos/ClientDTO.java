package com.example.Task.Monitor.Domain.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class ClientDTO {

    @NotBlank(message = "Invalid name: Empty name")
    @NotNull(message = "Invalid name: Name is null")
    private String name;

    private String address;

    private String phone;

    private String priority;

}

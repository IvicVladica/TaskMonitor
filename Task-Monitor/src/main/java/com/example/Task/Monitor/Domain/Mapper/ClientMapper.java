package com.example.Task.Monitor.Domain.Mapper;

import com.example.Task.Monitor.Domain.Dtos.ClientDTO;
import com.example.Task.Monitor.Domain.Entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client ClientDtoToEntity(ClientDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setAddress(dto.getAddress());
        client.setPhone(dto.getPhone());
        client.setPriority(dto.getPriority());
        return client;
    }

    public ClientDTO ClientEntityToDto(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setName(client.getName());
        dto.setAddress(client.getAddress());
        dto.setPhone(client.getPhone());
        dto.setPriority(client.getPriority());
        return dto;
    }
}

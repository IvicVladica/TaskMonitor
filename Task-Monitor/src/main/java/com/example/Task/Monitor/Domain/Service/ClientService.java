package com.example.Task.Monitor.Domain.Service;

import com.example.Task.Monitor.Domain.Dtos.ClientDTO;
import com.example.Task.Monitor.Domain.Entity.Client;
import com.example.Task.Monitor.Domain.Mapper.ClientMapper;
import com.example.Task.Monitor.Exceptions.NoIdExistsException;
import com.example.Task.Monitor.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientMapper clientMapper;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }


    public List<ClientDTO> getAllClients() {
        List<Client> allClients = clientRepository.findAll();
        List<ClientDTO> allClientsDto = new ArrayList<>();
        for (var client : allClients) {
            allClientsDto.add(clientMapper.ClientEntityToDto(client));
        }
        return allClientsDto;
    }

    public void createClient(ClientDTO clientDto) {
        Client client = clientMapper.ClientDtoToEntity(clientDto);
        clientRepository.save(client);
    }

    public void updateClient(Client client, UUID id) {
        if (clientRepository.findByClientId(id) == null) {
            throw new NoIdExistsException();
        }
        Client myClient = clientRepository.findByClientId(id);
        myClient.setName(client.getName());
        myClient.setAddress(client.getAddress());
        myClient.setPhone(client.getPhone());
        myClient.setPriority(client.getPriority());
        clientRepository.save(myClient);
    }

    public void deleteClient(UUID id) {
        if (clientRepository.findByClientId(id) == null) {
            throw new NoIdExistsException();
        }
        clientRepository.deleteByClientId(id);
    }

    public List<Client> findClientsByIdList(List<UUID> id) {
        List<Client> foundedClients = new ArrayList<>();
        for (var el : id) {
            foundedClients.add(clientRepository.findByClientId(el));
        }
        return foundedClients;
    }

    public void updateClientPriority(UUID id, Integer currentCount) {
        Client myClient = clientRepository.findByClientId(id);
        if (currentCount < 5) {
            myClient.setPriority("low");
        } else if (currentCount < 10) {
            myClient.setPriority("medium");
        } else myClient.setPriority("high");
        clientRepository.save(myClient);
    }

}

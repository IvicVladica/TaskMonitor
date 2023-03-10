package com.example.Task.Monitor.Service;

import com.example.Task.Monitor.Model.Client;
import com.example.Task.Monitor.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {return clientRepository.findAll();}

    public void createClient (Client client) {clientRepository.save(client);}

    public void updateClient (Client client, UUID id) {
        Client myClient = clientRepository.findByClientId(id);
        myClient.setName(client.getName());
        myClient.setAddress(client.getAddress());
        myClient.setPhone(client.getPhone());
        myClient.setPriority(client.getPriority());
        clientRepository.save(myClient);
    }

    public void deleteClient (UUID id) {clientRepository.deleteByClientId(id);}

    public List<Client> findClientsByIdList(List<UUID> id) {
        List<Client> foundedClients = new ArrayList<>();
        for (var el : id) {
            foundedClients.add(clientRepository.findByClientId(el));
        }
        return foundedClients;
    }

    public void updateClientPriority(UUID id, Integer currentCount) {
        Client myClient = clientRepository.findByClientId(id);
        if (currentCount < 5) {myClient.setPriority("low");}
        else if (currentCount <10) {myClient.setPriority("medium");}
        else myClient.setPriority("high");
        clientRepository.save(myClient);
    }

}

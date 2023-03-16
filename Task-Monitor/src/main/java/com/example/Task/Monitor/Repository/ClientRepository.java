package com.example.Task.Monitor.Repository;

import com.example.Task.Monitor.Domain.Entity.Client;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    Client findByClientId (UUID id);

    @Transactional
    void deleteByClientId (UUID id);
}

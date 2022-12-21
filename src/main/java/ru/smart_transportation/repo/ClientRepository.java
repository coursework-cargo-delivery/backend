package ru.smart_transportation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smart_transportation.entity.AppUser;
import ru.smart_transportation.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findClientByAppUser(AppUser appUser);
}


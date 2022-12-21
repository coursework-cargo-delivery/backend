package ru.smart_transportation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smart_transportation.dto.request.NewUser;
import ru.smart_transportation.entity.AppUser;
import ru.smart_transportation.entity.Client;
import ru.smart_transportation.repo.ClientRepository;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client createClient(NewUser bigProfile, AppUser user){
        final var client = new Client();

        client.setAppUser(user);
        client.setCompanyName(bigProfile.getCompanyName());
        client.setPhoneNumber(bigProfile.getPhoneNumber());

        return clientRepository.save(client);
    }
}

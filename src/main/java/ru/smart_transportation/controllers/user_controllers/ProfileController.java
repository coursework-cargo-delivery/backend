package ru.smart_transportation.controllers.user_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smart_transportation.dto.response.GetProfileResponse;
import ru.smart_transportation.repo.ClientRepository;
import ru.smart_transportation.service.AppUserService;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class ProfileController {

    @Autowired
    AppUserService userService;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("profile")
    ResponseEntity<GetProfileResponse> getClientProfile(){
        final var user = userService.getCurrentUser().orElseThrow();
        final var client = clientRepository.findClientByAppUser(user);
        final var profile = new GetProfileResponse();

        profile.setCompanyName(client.getCompanyName());
        profile.setPhoneNumber(client.getPhoneNumber());

        return ResponseEntity.ok(profile);
    }
}

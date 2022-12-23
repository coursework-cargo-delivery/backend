package ru.smart_transportation.controllers.client_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smart_transportation.dto.request.NewProfile;
import ru.smart_transportation.dto.response.ProfileResponse;
import ru.smart_transportation.repo.ClientRepository;
import ru.smart_transportation.service.AppUserService;

@RestController
@CrossOrigin("*")
@RequestMapping("user/profile")
public class ProfileController {

    @Autowired
    AppUserService userService;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("")
    ResponseEntity<ProfileResponse> getClientProfile(){
        final var user = userService.getCurrentUser().orElseThrow();
        final var client = clientRepository.findClientByAppUser(user);
        final var profile = new ProfileResponse();

        profile.setCompanyName(client.getCompanyName());
        profile.setPhoneNumber(client.getPhoneNumber());

        return ResponseEntity.ok(profile);
    }

    @PostMapping("update")
    ResponseEntity<ProfileResponse> updateProfile(@RequestBody NewProfile newProfile){
        final var user = userService.getCurrentUser().orElseThrow();
        final var oldProfile = clientRepository.findClientByAppUser(user);

        oldProfile.setCompanyName(newProfile.getCompanyName());
        oldProfile.setPhoneNumber(newProfile.getPhoneNumber());
        clientRepository.updateCompanyNameAndPhoneNumberById(newProfile.getCompanyName(),
                newProfile.getPhoneNumber(), oldProfile.getId());

        return getClientProfile();
    }
}

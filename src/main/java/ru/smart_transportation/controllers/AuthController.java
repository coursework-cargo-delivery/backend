package ru.smart_transportation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.smart_transportation.dto.request.NewUser;
import ru.smart_transportation.dto.request.OldUser;
import ru.smart_transportation.entity.AppUser;
import ru.smart_transportation.repo.AppUserRepository;
import ru.smart_transportation.security.JwtTokenProvider;

@RestController
@CrossOrigin("*")
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    JwtTokenProvider jwtUtils;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("signin")
    String canSignIn(@RequestBody OldUser user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken(authentication);

        return jwt;
    }

    @PostMapping("signup")
    ResponseEntity<String> canSignIn(@RequestBody NewUser newUser){
        if (userRepository.existsByUsername(newUser.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        // Create new user's account
        AppUser appUser = new AppUser();
        appUser.setUsername(newUser.getUsername());
        appUser.setPassword(encoder.encode(newUser.getPassword()));

        userRepository.save(appUser);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(newUser.getUsername(), newUser.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken(authentication);

        return ResponseEntity.ok("Bearer " + jwt);
    }
}

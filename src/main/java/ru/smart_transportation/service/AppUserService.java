package ru.smart_transportation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.smart_transportation.entity.AppUser;
import ru.smart_transportation.repo.AppUserRepository;
import java.util.Optional;

@Service
public class AppUserService {

    @Autowired
    AppUserRepository userRepository;

    public Optional<AppUser> getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return userRepository.findByUsername(userName);
    }
}

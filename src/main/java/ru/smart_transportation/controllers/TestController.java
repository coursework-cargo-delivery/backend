package ru.smart_transportation.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("test")
public class TestController {

    @GetMapping("secret")
    String getSecret(){
        return "I know a secret";
    }
}

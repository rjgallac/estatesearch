package uk.co.sheffieldwebprogrammer.estatesearch.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userservice")
public class UserController {

    @GetMapping
    public void getUser(){

    }
}

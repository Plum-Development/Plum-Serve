package org.plumdev.serve.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String login() {
        return "login page";
    }

    // post mapping goes here
//    @PostMapping
}

package com.retromercury.mdm.api.controller;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    public UserController() {
        log.error("--------------------------------------UserController initialized");
    }

    @PostConstruct
    public void init() {
        log.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!UserController initialized");
    }

    @GetMapping("/createUser")
    public ResponseEntity<String> createUser() {
        return ResponseEntity.ok("Привет");
    }
}

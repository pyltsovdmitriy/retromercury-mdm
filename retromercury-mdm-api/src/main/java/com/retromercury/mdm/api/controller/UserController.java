package com.retromercury.mdm.api.controller;

import java.util.concurrent.Executors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retromercury.mdm.kafka.service.KafkaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final KafkaService kafkaService;

    @GetMapping("/createUser")
    public ResponseEntity<String> createUser() {

        return ResponseEntity.ok("Привет");

    }

    @GetMapping("/killDiminiShluhi")
    public ResponseEntity<String> killDiminiShluhi() {
        Executors.newSingleThreadExecutor().submit(() -> kafkaService.sendMessage());
        return ResponseEntity.ok("Начал убивать");
    }
}

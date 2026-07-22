package com.navira.contactus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LonginController {

    @GetMapping()
    public ResponseEntity<String> checkActive(){
        String randId = UUID.randomUUID().toString();
        return ResponseEntity.ok("it is active with ID "+ randId );
    }

}

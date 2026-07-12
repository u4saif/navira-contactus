package com.navira.contactus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("contact")
public class ContactController {

    @GetMapping("/all")
    public ResponseEntity<String> getContacts(){
        return ResponseEntity.ok("Hello from server");
    }
}

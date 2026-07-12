package com.navira.contactus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navira.contactus.dto.ContactRequestDto;
import com.navira.contactus.dto.ContactResponseDto;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @GetMapping("/all")
    public ResponseEntity<String> getContacts(){
        return ResponseEntity.ok("Hello from server");
    }

    @PostMapping("/new")
    public ResponseEntity<ContactResponseDto> createNewContact(@RequestBody ContactRequestDto requestData){

        return ResponseEntity.ok(null);
    }
}

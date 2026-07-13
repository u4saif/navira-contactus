package com.navira.contactus.controller;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navira.contactus.dto.ContactRequestDto;
import com.navira.contactus.dto.ContactResponseDto;
import com.navira.contactus.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<?> getContacts() {
        return ResponseEntity.ok().body(java.util.Map.of("message", "Hello from server"));
    }

    @PostMapping
    public ResponseEntity<ContactResponseDto> createNewContact(@Valid @RequestBody ContactRequestDto requestData) {
        ContactResponseDto response = this.contactService.createNew(requestData);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

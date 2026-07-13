package com.navira.contactus.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.navira.contactus.dto.ContactRequestDto;
import com.navira.contactus.dto.ContactResponseDto;
import com.navira.contactus.entity.Contact;
import com.navira.contactus.repository.ContactRepository;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    public ContactResponseDto createNew(ContactRequestDto request) {
        Contact newContact = mapToEntity(request);
        Contact savedItem = this.contactRepository.save(newContact);

        return mapToDto(newContact);
    }

    private Contact mapToEntity(ContactRequestDto contactRequestDto) {
        Contact newItem = new Contact();
        newItem.setName(contactRequestDto.getName());
        newItem.setEmail(contactRequestDto.getEmail());
        newItem.setCreatedAt(LocalDateTime.now());
        newItem.setPhone(contactRequestDto.getPhone());
        return  newItem;
    }

     private ContactResponseDto mapToDto(Contact contact) {
        ContactResponseDto responseDto = new ContactResponseDto();

        responseDto.setId(contact.getId());  
        responseDto.setMessage("Details saved successfully. Team will contact shortly");
        responseDto.setCreatedAt(contact.getCreatedAt()); 

        return responseDto;

    }
}

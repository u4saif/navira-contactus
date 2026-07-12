package com.navira.contactus.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;

public class ContactResponseDto {

    @NotBlank
    long id;

    @NotBlank
    Date createdAt;

    @NotBlank
    String message;

}

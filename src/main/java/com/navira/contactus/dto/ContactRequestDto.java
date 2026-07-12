package com.navira.contactus.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ContactRequestDto {
    @NotBlank
    String name;

    @Email
    String email;

    @NotBlank
    @Min(10)
    String phone;

    @NotBlank
    String message;
}

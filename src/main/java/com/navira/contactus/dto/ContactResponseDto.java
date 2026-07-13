package com.navira.contactus.dto;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;

public class ContactResponseDto {

    @NotBlank
    long id;

    @NotBlank
    LocalDateTime createdAt;

    @NotBlank
    String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

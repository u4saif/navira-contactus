package com.navira.contactus;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.navira.contactus.controller.ContactController;
import com.navira.contactus.dto.ContactRequestDto;
import com.navira.contactus.dto.ContactResponseDto;
import com.navira.contactus.service.ContactService;

class ContactControllerTest {

    private MockMvc mockMvc;
    private ContactService contactService;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        contactService = mock(ContactService.class);
        objectMapper = new ObjectMapper();
        ContactController controller = new ContactController(contactService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getContactsReturnsOkResponse() throws Exception {
        mockMvc.perform(get("/contacts"))
                .andExpect(status().isOk());
    }

    @Test
    void createContactReturnsCreatedResponse() throws Exception {
        ContactRequestDto request = new ContactRequestDto();
        request.setName("Alice");
        request.setEmail("alice@example.com");
        request.setPhone("1234567890");
        request.setMessage("Hello from test");

        ContactResponseDto response = new ContactResponseDto();
        response.setId(1L);
        response.setMessage("Hello from test");
        response.setCreatedAt(LocalDateTime.now());

        when(contactService.createNew(any(ContactRequestDto.class))).thenReturn(response);

        mockMvc.perform(post("/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1));
    }
}

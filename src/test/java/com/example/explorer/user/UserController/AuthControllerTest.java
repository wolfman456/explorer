package com.example.explorer.user.UserController;

import com.example.explorer.user.UserService.AuthService;
import com.example.explorer.user.User_model.dto.RegisterDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class AuthControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;


    @Test
    public void testRegister() throws Exception, JsonProcessingException {
        Set<String> role = new HashSet<>();
        role.add("user");

        RegisterDto registerDto = new RegisterDto("bob", "bobby","john.doe@example.com", "password123",role);

        String mockResponse = "User registered successfully";
        when(authService.register(registerDto)).thenReturn(mockResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(registerDto);

    mockMvc.perform(get("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.TEXT_EVENT_STREAM)
                        .content(requestBody))
                .andExpect(status().isCreated()).andReturn();
    }
}

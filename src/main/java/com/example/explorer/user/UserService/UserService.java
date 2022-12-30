package com.example.explorer.user.UserService;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserService {
    String suspendUser(String userName) throws JsonProcessingException;
}

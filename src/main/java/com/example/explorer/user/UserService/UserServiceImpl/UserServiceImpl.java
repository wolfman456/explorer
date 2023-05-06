package com.example.explorer.user.UserService.UserServiceImpl;

import com.example.explorer.utility.exception.InformationNotFoundException;
import com.example.explorer.user.UserService.UserService;
import com.example.explorer.user.User_model.UserModel;
import com.example.explorer.user.user_repo.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String suspendUser(String userName) throws InformationNotFoundException, JsonProcessingException {
        UserModel user = userRepository.findByUserName(userName).get();
        if (user != null) {
            user.setIsActive(false);
            userRepository.save(user);
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            String jsonString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(user);
            return jsonString;
        }else {
            throw new InformationNotFoundException(HttpStatus.NOT_FOUND, "no user with found with name : "
                    + userName, LocalDateTime.now());
        }
    }
}

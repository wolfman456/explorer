package com.example.explorer.user.UserController;

import com.example.explorer.utility.exception.InformationNotFoundException;
import com.example.explorer.user.UserService.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/")
public class UserController {

    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("suspend/{userName}")
    @PreAuthorize("hasRole('ADMIN, MODERATOR')")
    public ResponseEntity<?> suspendUser(@PathVariable(value = "userName") String userName){
        try {
            if (!userName.isEmpty()){
                return ResponseEntity.ok("User : " + userService.suspendUser(userName));
            }
        }catch (InformationNotFoundException | JsonProcessingException notFoundException){
            logger.debug("suspend user failed with message : " + notFoundException.getMessage());
            return ResponseEntity.badRequest().body("No User with Name : " + userName + " found");
        }catch (Exception e){
            logger.debug("Exception occurred well processing suspendUser with message : " + e.getMessage());
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.status(500).build();
    }

}

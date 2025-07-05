package com.easybank.easybank.controller;

import com.easybank.easybank.DTO.ApiResponse;
import com.easybank.easybank.DTO.UserDto;
import com.easybank.easybank.model.User;
import com.easybank.easybank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> RegisterUser(@RequestBody UserDto userDto){
        User savedUser = null;
        ResponseEntity<ApiResponse> responseEntity = null;
        try{
            if(userService.getUserByUserName(userDto.getUsername()).isPresent()){
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(new ApiResponse("Username already exists", 409, null));
            }
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            User user = userService.convertUserDtoToEntity(userDto);
            savedUser = userService.CreateUser(user);
            if (savedUser.getId()>0){
                responseEntity =ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("User registered successfully", 201, "userId: " + savedUser.getId()));
            }

        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Server error: " + e.getMessage(), 500, null));
        }
        return  responseEntity;
    }

}

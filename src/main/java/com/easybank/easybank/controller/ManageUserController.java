package com.easybank.easybank.controller;

import com.easybank.easybank.DTO.ApiResponse;
import com.easybank.easybank.DTO.UserDto;
import com.easybank.easybank.model.User;
import com.easybank.easybank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ManageUserController {
    @Autowired
    UserService userService;
    @GetMapping("/manage")
    public ResponseEntity<ApiResponse> getAllUser(){
        List<User> users = userService.getAllUser();
        ResponseEntity<ApiResponse> responseEntity = null;
        if (!users.isEmpty()) {
            List<UserDto> userDtos = users.stream().map((user) -> {
                return userService.convertUserToUserDto(user);
            }).collect(Collectors.toList());
            responseEntity = ResponseEntity.status(HttpStatus.FOUND).body(new ApiResponse("get all user",302,userDtos));
        }else {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("user is null",500,null));
        }
        return responseEntity;
    }
}

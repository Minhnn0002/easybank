package com.easybank.easybank.services;

import com.easybank.easybank.DTO.UserDto;
import com.easybank.easybank.model.Authorities;
import com.easybank.easybank.model.User;
import com.easybank.easybank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public Optional<User> getUserByUserName(String userName){
        return userRepository.findByEmail(userName);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User CreateUser(User user){
        return userRepository.save(user);
    }
    public User convertUserDtoToEntity(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        Set<Authorities> setAuthorities = userDto.getRole().stream()
                .map((role) -> {
                    Authorities authorities = new Authorities(role);
                    authorities.setUser(user);
                    return authorities;
                }).collect(Collectors.toSet());
        user.setAuthority(setAuthorities);
        return user;
    }

    public UserDto convertUserToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());

        List<String> roles = user.getAuthorities().stream()
                        .map((authority)->{
                            return authority.getAuthority();
                        }).collect(Collectors.toList());

        userDto.setRole(roles);
        return userDto;
    }
}

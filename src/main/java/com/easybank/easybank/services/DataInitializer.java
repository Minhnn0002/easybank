//package com.easybank.easybank.services;
//
//import com.easybank.easybank.model.Authorities;
//import com.easybank.easybank.model.User;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class DataInitializer {
//    @Autowired UserService userService;
//    @Autowired AuthoritiesService authoritiesService;
//    @PostConstruct
//    @Transactional
//    public void initData() {
//        Authorities adminRole = new Authorities();
//        adminRole.SetRole("admin");
//        Authorities userRole = new Authorities();
//        userRole.SetRole("user");
//        User user = new User("adminuser","{noop}12345");
//        Set<Authorities> authorities = new HashSet<>();
//        adminRole.setUser(user);
//        userRole.setUser(user);
//        authorities.add(adminRole);
//        authorities.add(userRole);
//        user.setAuthority(authorities);
//        userService.CreateUer(user);
//    }
//}

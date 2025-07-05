package com.easybank.easybank.services;

import com.easybank.easybank.model.Authorities;
import com.easybank.easybank.repositories.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthoritiesService {
    @Autowired
    AuthoritiesRepository authoritiesRepository;
    void CreateRole(Authorities authorities){
        authoritiesRepository.save(authorities);
    }
    Authorities FindByRole(String Role){
        return authoritiesRepository.findByRole(Role).get();
    }
}

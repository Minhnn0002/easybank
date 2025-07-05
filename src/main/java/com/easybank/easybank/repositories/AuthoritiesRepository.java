package com.easybank.easybank.repositories;

import com.easybank.easybank.model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities,Long> {
    Optional<Authorities> findByRole(String Role);
}

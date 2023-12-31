package com.example.demo.repository;

import com.example.demo.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<ApplicationUser, Long> {
    public ApplicationUser findByEmail(String email);
    ApplicationUser findByActivationCode(String code);
}
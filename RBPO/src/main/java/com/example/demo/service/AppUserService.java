package com.example.demo.service;
import com.example.demo.model.ApplicationUser;
import com.example.demo.model.Role;
import com.example.demo.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
@Slf4j

public class AppUserService {
    private final AppUserRepository appUserRepository;
    public ApplicationUser getAppUserByEmail(String email) {
        return AppUserRepository.findByEmail(email);
    }
}

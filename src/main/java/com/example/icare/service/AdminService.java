package com.example.icare.service;

import com.example.icare.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.icare.repository.user.User;
@AllArgsConstructor
@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}



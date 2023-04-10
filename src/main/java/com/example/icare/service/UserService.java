package com.example.icare.service;
import com.example.icare.domain.AppUserRole;
import com.example.icare.domain.User;
import com.example.icare.repository.PatientRepository;
import com.example.icare.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;


@Service

public class UserService  {
   private final UserRepository userRepository;
@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // @Autowired
  // private EmailService emailService; // assume EmailService is a service to send emails

    // User Registration
    public User registerUser(String email, String password, String  role) {
        // Check if email already exists
        if (userRepository.findByEmail(email) != null) {
            throw new RuntimeException("Email already exists");
        }

        // Create a new User
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        user.setEmailVerified(false);

        // Save the user to the database
        return userRepository.save(user);
    }
    // User Login
    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        // Check if password matches
        if (!Objects.equals(password, user.getPassword())) {
            throw new RuntimeException("Incorrect password");
        }

        return user;
    }

    // Email Verification
    public void verifyEmail(String email) {
        User user = userRepository.findByEmail(email) ;
        if (user != null) {
            user.setEmailVerified(true);
            userRepository.save(user);
        }
    }


}

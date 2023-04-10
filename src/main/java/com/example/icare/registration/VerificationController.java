/*package com.example.icare.registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationController {

    // Inject the PasswordEncoder bean
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Email Verification
    @GetMapping("/verify/{userId}")
    public void verifyEmail(@PathVariable Long userId, @RequestParam String password) {
        // Fetch the user from the database based on userId

        // Verify the user's email

        // Encode the password using the PasswordEncoder
        String encodedPassword = passwordEncoder.encode(password);

        // Save the encoded password for the user

        // Other verification logic

        // Return a response or perform necessary actions
    }
}*/
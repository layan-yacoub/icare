package com.example.icare.controller;

import com.example.icare.domain.AppUserRole;
import com.example.icare.domain.User;
import com.example.icare.registration.UserRegistrationRequest;
import com.example.icare.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController //is used in REST Web services & mark class as Controller Class

@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody UserRegistrationRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();
        String role = request.getRole();

        // Call the UserService to register a new user
        return userService.registerUser(email, password, role);
    }

    @GetMapping("/verify/{email}")
    public void verifyEmail(@PathVariable String email) {
        System.out.println("work");
        userService.verifyEmail(email);
    }

    @PostMapping("/login")
    public User loginUser(@RequestParam String email, @RequestParam String password) {
        return userService.loginUser(email, password);

    }


    @Autowired
   
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Pong!");
    }

  
}

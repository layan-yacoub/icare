package com.example.icare.repository;

import com.example.icare.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository //JPA Repository is mainly used for managing the data in a Spring Boot Application
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}

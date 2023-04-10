package com.example.icare.repository;

import com.example.icare.domain.Patient;
import com.example.icare.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;


@Repository
@Transactional(readOnly = true)
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Optional <Patient> findByEmail(String email);
}

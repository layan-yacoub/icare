package com.example.icare.service;

import com.example.icare.domain.Patient;
import com.example.icare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long patiant_id) {
        return patientRepository.findById(patiant_id).orElse(null);
    }

 
   @Autowired
   private NutritionistRepository nutritionistRepository;

   public List<Nutritionist> getNutritionCenters() {
       return nutritionistRepository.findAll();}

   public int getPatientAge(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) {
            throw new IllegalArgumentException("Patient not found");
        }
        LocalDate dob = patient.getDateOfBirth();
        if (dob == null) {
            throw new IllegalArgumentException("Patient date of birth not found");}
        return Period.between(dob, LocalDate.now()).getYears();
    }
}




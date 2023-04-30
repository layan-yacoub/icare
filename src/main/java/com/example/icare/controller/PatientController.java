package com.example.icare.controller;

import com.example.icare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;



@RestController //is used in REST Web services & mark class as Controller Class
@RequestMapping(path ="api/patient") //is used at the class level while
public class PatientController {
    @Autowired
    private final PatientService patientService;
@Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


  

   @Autowired
  

   @GetMapping("/nutrition-centers")
   public List<Nutritionist> getNutritionCenters() {
       return patientService.getNutritionCenters();
   }
   
   @GetMapping("/{patientId}/age")
    public ResponseEntity<Integer> getPatientAge(@PathVariable Long patientId) {
        try {
            int age = patientService.getPatientAge(patientId);
            return ResponseEntity.ok(age);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}



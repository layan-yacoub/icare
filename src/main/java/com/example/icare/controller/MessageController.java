package com.example.icare.controller;

import com.example.icare.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping
public class MessageController {
    @Autowired
    private final MessageService messageService;
    @PostMapping
    public void sendMessage(@RequestParam Long nutritionistId, @RequestParam Long patientId, @RequestParam String content, @RequestParam(required = false) MultipartFile attachment) throws IOException {
        Nutritionist nutritionist = nutritionistRepository.findById(nutritionistId).orElseThrow(() -> new EntityNotFoundException("Nutritionist not found"));
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found"));
         messageService.sendMessage(nutritionist, patient, content, attachment);
    }
    
@GetMapping("/{messageId}/attachment")
    public ResponseEntity<byte[]> downloadAttachment(@PathVariable Long messageId) {
        byte[] attachmentData = messageService.getAttachmentData(messageId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("diet_plan.pdf").build());
        return new ResponseEntity<>(attachmentData, headers, HttpStatus);
        }
}

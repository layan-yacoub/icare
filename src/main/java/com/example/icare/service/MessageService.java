package com.example.icare.service;


import com.example.icare.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class MessageService {
    @Autowired
    private final MessageRepository messageRepository;
     public void sendMessage(Nutritionist nutritionist, Patient patient, String content, MultipartFile attachment) throws IOException {
        Message message = new Message();
        message.setContent(content);
        message.setSentAt(LocalDateTime.now());
        message.setHasAttachment(false);
        message.setNutritionist(nutritionist);
        message.setPatient(patient);
        
        if (attachment != null && !attachment.isEmpty()) {
            message.setHasAttachment(true);
            message.setAttachmentName(attachment.getOriginalFilename());
            message.setAttachmentData(attachment.getBytes());
        }
        
        messageRepository.save(message);
    }

    public byte[] getAttachmentData(Long messageId) {
        Message message = messageRepository.findById(messageId).orElseThrow(() -> new EntityNotFoundException("Message not found"));
        if (!message.isHasAttachment()) {
            throw new IllegalStateException("Message does not have an attachment");
        }
        
        return message.getAttachmentData();
    }
}

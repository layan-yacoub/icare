package com.example.icare.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long message_id ;
    private String message_text ;
    private LocalDateTime sentAt;
    private boolean hasAttachment;
    private String attachmentName;
    @Lob
    private byte[] attachment;
    private Timestamp message_date;

    //private int patient_id ;
    //private int  nutritionist_id;

    @ManyToOne
    @JoinColumn(name = "nutritionist_id")
    private Nutritionist nutritionist;

    @ManyToOne(fetch = FetchType.LAZY) // Many-to-one relationship with nutritionist
    @JoinColumn(name = "patient_id")
    private Patient patient;

  
}

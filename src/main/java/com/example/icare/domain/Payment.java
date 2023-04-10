package com.example.icare.domain;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="payment")
   public class Payment {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long payment_id; //primary key
   private Timestamp payment_date;
   private double payment_amount;
   private int appointment_id;  //foreign key with appointment table


   /*@ManyToOne(fetch = FetchType.LAZY)// Many-to-one relationship with nutritionist the related entity will not be loaded from the database until it is actually accessed.
   @JoinColumn(name = "nutritionist_id")
   private Nutritionist nutritionist;
   @ManyToOne(fetch = FetchType.LAZY) // Many-to-one relationship with patient the related entity will not be loaded from the database until it is actually accessed.
  // @JoinColumn(name = "patient_id")
   private Patient patient; */



}
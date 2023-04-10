package com.example.icare.domain;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long restaurant_id  ; // primary key derived from the superclass user_id and concatenated with a character 'R'
    private String  phone_number;
    private String restaurant_name ;
    private String restaurant_location;
    @Lob
    private byte[] restaurant_license  ;
    private String social_media  ;
    private boolean statues;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    /*@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)    // Relationships with Report entity
    private List<Report> reports = new ArrayList<>();*/

    /*@PostPersist  //ensures that this method is called after the entity is persisted to the database.
    public void generateRestaurantId() {
        restaurant_id = "R"+ getUser_id() ;
    }*/


}

package com.example.icare.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long user_id; //primary key
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private String role; // roles can be "patient", "nutritionist", "restaurant", or "admin"
    @Column(nullable = false)
    private String phone_number;
    private boolean emailVerified;
   

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)    // Relationships with Report entity
    private List<Report> reports = new ArrayList<>();

    public User(String email, String password, String phone_number, String role) {
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.role = role;
       
    }
    public User(String email) {
        this.email = email;
    } // email is a foreign key
    public boolean isEmailVerified() {
        return emailVerified;
    }   
}

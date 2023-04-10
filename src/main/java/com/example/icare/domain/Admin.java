package com.example.icare.domain;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@ToString
@EqualsAndHashCode
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="admin")
public class Admin {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long admin_id; //primary key
    private String email;
    private String password;
    private String name;


}

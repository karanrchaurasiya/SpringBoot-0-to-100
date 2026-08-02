package org.example.patientmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.patientmanagementsystem.entity.type.BloodGroupType;
import org.example.patientmanagementsystem.entity.type.GenderType;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;
}

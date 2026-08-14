package org.example.hospitalmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.hospitalmanagementsystem.entity.type.BloodGroupType;
import org.example.hospitalmanagementsystem.entity.type.GenderType;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "patient_insurance")
    private Insurance insurance; //owning side

    @OneToMany(mappedBy = "patient") // inverse side
    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<>();
}

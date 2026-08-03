package org.example.hospitalmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hospitalmanagementsystem.entity.type.AppointmentStatusType;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 300)
    private String reason;

    @Enumerated(EnumType.STRING)
    private AppointmentStatusType status;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Patient patient;  // owning side

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor; // owning side
}

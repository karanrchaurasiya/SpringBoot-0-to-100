package org.example.hospitalmanagementsystem.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hospitalmanagementsystem.entity.type.BloodGroupType;
import org.example.hospitalmanagementsystem.entity.type.GenderType;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100,
            message = "Name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @NotNull(message = "Gender is required")
    private GenderType gender;

    @NotNull(message = "Blood group is required")
    private BloodGroupType bloodGroup;
}

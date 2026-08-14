package com.example.coursemanagementsystem.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    @NotBlank(message = "Name required")
    @Size(min = 3, max = 50, message = "Name must be greater than 3 letter and Less than 50 Letter")
    private String name;

    @NotBlank
    @Email(message = "Enter valid Email")
    private String email;

    @NotNull
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @NotBlank
    @Pattern( regexp = "^[0-9]{10}$",
            message = "Phone must contain exactly 10 digits")
    private String phone;
}

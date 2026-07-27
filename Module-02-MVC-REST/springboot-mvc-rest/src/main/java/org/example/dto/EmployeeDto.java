package org.example.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.annotations.EmployeeRoleValidation;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long id;
    @NotEmpty
    @Size(min = 1, max = 30)
    private String name;

    @NotEmpty
    @Email
    private String email;

    @Max(value = 60)
    @Min(value = 18)
    @NotNull
    private Integer age;

    @NotEmpty
//    @Pattern(regexp = "^(ADMIN|USER)$")
    @EmployeeRoleValidation
    private String role;

    @PositiveOrZero
    @NotNull
    @Digits(integer = 6, fraction = 2)
    private Double salary;

    @PastOrPresent
    private LocalDate dateOfJoining;


    private Boolean isActive;

}

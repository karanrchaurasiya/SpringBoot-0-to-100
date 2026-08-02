package org.example.patientmanagementsystem.advices;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    private T body;
    private ApiError apiError;

    @JsonFormat(pattern = "hh:mm:ss dd-MM-yyyyy")
    private LocalDateTime timestamp = LocalDateTime.now();


    public ApiResponse(ApiError apiError) {
        this.apiError = apiError;
    }

    public ApiResponse(T body) {
        this.body = body;
    }
}



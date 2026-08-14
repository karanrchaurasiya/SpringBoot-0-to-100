package com.example.coursemanagementsystem.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class ErrorResponse {
    private HttpStatus status;
    private String message;
    private Map<String, String> errors;
}

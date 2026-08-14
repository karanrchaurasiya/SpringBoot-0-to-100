package org.example.hospitalmanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.hospitalmanagementsystem.entity.Doctor;
import org.example.hospitalmanagementsystem.service.DoctorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public void addNewDoctor(@RequestBody Doctor doctor) {
        doctorService.addNewDoctor(doctor);
    }
}

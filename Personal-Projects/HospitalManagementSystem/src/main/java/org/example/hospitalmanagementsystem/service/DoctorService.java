package org.example.hospitalmanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.hospitalmanagementsystem.entity.Doctor;
import org.example.hospitalmanagementsystem.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public void addNewDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }
}

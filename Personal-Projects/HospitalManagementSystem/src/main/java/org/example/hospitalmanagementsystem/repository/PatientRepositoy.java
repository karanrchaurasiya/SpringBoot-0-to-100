package org.example.hospitalmanagementsystem.repository;

import org.example.hospitalmanagementsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepositoy extends JpaRepository<Patient, Long> {
}

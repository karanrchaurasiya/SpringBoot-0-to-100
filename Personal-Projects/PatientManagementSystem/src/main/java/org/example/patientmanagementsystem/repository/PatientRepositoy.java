package org.example.patientmanagementsystem.repository;

import org.example.patientmanagementsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepositoy extends JpaRepository<Patient, Long> {
}

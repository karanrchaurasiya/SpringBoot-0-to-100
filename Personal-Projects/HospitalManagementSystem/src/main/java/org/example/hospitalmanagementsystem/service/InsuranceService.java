package org.example.hospitalmanagementsystem.service;

import jakarta.transaction.Transactional;
import org.example.hospitalmanagementsystem.entity.Insurance;
import org.example.hospitalmanagementsystem.entity.Patient;
import org.example.hospitalmanagementsystem.repository.AppointmentRepository;
import org.example.hospitalmanagementsystem.repository.InsuranceRepository;
import org.example.hospitalmanagementsystem.repository.PatientRepositoy;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepositoy patientRepositoy;

    public InsuranceService(InsuranceRepository insuranceRepository, PatientRepositoy patientRepositoy) {
        this.insuranceRepository = insuranceRepository;
        this.patientRepositoy = patientRepositoy;
    }

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepositoy.findById(patientId).orElseThrow();

        Insurance savedInsurance = insuranceRepository.save(insurance);
        patient.setInsurance(savedInsurance);

        patientRepositoy.save(patient);
        insurance.setPatient(patient);  // Optional

        return savedInsurance;
    }

    public List<Insurance> getAllInsurances() {
        return insuranceRepository.findAll();
    }

    public Insurance getInsuranceById(Long id) {
       return insuranceRepository.findById(id).orElseThrow();
    }

}

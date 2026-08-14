package org.example.hospitalmanagementsystem.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.hospitalmanagementsystem.entity.Appointment;
import org.example.hospitalmanagementsystem.entity.Doctor;
import org.example.hospitalmanagementsystem.entity.Patient;
import org.example.hospitalmanagementsystem.repository.AppointmentRepository;
import org.example.hospitalmanagementsystem.repository.DoctorRepository;
import org.example.hospitalmanagementsystem.repository.PatientRepositoy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepositoy patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long patientId, Long doctorId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Transactional
    public void deleteAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        appointmentRepository.delete(appointment);
    }

    public Appointment getAppointmentById(Long id) {
       return appointmentRepository.findById(id).orElseThrow();
    }
}

package org.example.hospitalmanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.hospitalmanagementsystem.entity.Appointment;
import org.example.hospitalmanagementsystem.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/patients/{patientId}/doctors/{doctorId}")
    public ResponseEntity<Appointment> createNewAppointment(
            @RequestBody Appointment appointment,
            @PathVariable Long patientId,
            @PathVariable Long doctorId) {
       Appointment savedAppointment = appointmentService.createNewAppointment(appointment, patientId, doctorId);

       return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/{id")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> deleteAppointmentById(@PathVariable Long appointmentId) {
        appointmentService.deleteAppointmentById(appointmentId);
        return ResponseEntity.noContent().build();
    }

}

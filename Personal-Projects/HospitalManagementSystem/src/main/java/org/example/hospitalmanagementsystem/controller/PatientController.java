package org.example.hospitalmanagementsystem.controller;

import jakarta.validation.Valid;
import org.example.hospitalmanagementsystem.dto.PatientDto;
import org.example.hospitalmanagementsystem.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id) {
        return
                ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping
    public ResponseEntity<PatientDto> createNewPatient(@RequestBody @Valid PatientDto newPatient) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(patientService.createNewPatient(newPatient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatientById(@PathVariable Long id) {
        patientService.deletePatientById(id);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatientById(@PathVariable Long id,
                                        @RequestBody @Valid PatientDto newPatient) {
        return new ResponseEntity<>(patientService.updatePatientById(id, newPatient), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatientDto> updatePartialPatientById(@PathVariable Long id, @RequestBody @Valid Map<String, Object> newPatient) {
        return ResponseEntity.ok(
                patientService.updatePartialPatientById(id, newPatient));
    }
}

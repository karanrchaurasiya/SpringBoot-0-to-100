package org.example.hospitalmanagementsystem.controller;

import org.example.hospitalmanagementsystem.entity.Insurance;
import org.example.hospitalmanagementsystem.service.InsuranceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping("/patient/{patientId}")
    public ResponseEntity<Insurance> assignInsuranceToPatient(
            @RequestBody Insurance insurance,
            @PathVariable Long patientId) {

        return ResponseEntity.ok(insuranceService.assignInsuranceToPatient(insurance, patientId));
    }

    @GetMapping
    public ResponseEntity<List<Insurance>> getAllInsurances(){
        return ResponseEntity.ok(insuranceService.getAllInsurances());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Insurance> getInsuranceById(@PathVariable Long id){
        return ResponseEntity.ok(insuranceService.getInsuranceById(id));
    }
}

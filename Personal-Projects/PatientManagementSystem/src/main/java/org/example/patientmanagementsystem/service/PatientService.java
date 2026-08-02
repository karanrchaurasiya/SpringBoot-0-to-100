package org.example.patientmanagementsystem.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.patientmanagementsystem.dto.PatientDto;
import org.example.patientmanagementsystem.entity.Patient;
import org.example.patientmanagementsystem.exceptions.ResourceNotFoundException;
import org.example.patientmanagementsystem.repository.PatientRepositoy;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepositoy patientRepositoy;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;

    public PatientService(PatientRepositoy patientRepositoy, ModelMapper modelMapper, ObjectMapper objectMapper) {
        this.patientRepositoy = patientRepositoy;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
    }


    public List<PatientDto> getAllPatients() {
        return patientRepositoy.findAll()
                .stream()
                .map(patient -> modelMapper.map(patient, PatientDto.class))
                .toList();
    }

    public Optional<PatientDto> getPatientById(Long id) {
        isPatientExistById(id);

        return patientRepositoy.findById(id)
                .map(patient -> modelMapper.map(patient, PatientDto.class));
    }


    public PatientDto createNewPatient(PatientDto newPatient) {
        Patient savedPatient = modelMapper.map(newPatient, Patient.class);
        patientRepositoy.save(savedPatient);
        return modelMapper.map(savedPatient, PatientDto.class);
    }

    public boolean deletePatientById(Long id) {
        isPatientExistById(id);
        patientRepositoy.deleteById(id);
        return true;
    }


    public PatientDto updatePatientById(Long id, PatientDto newPatient) {
       isPatientExistById(id);

       Patient patient = modelMapper.map(newPatient, Patient.class);
       patient.setId(id);
       patientRepositoy.save(patient);

       return modelMapper.map(patient, PatientDto.class);
    }

    public PatientDto updatePartialPatientById(Long id, Map<String, Object> newPatient) {

//        isPatientExistById(id);

        Patient patient = patientRepositoy.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));


//        Using Reflection-----
//
//        newPatient.forEach((key, value) -> {
//            Field fieldToUpdate = ReflectionUtils.getRequiredField(Patient.class ,key);
//            fieldToUpdate.setAccessible(true);
//            ReflectionUtils.setField(fieldToUpdate,patient,value);
//        });
//        return modelMapper.map(patientRepositoy.save(patient), PatientDto.class);


//        Using ObjectMapper-----

        try {
            objectMapper.updateValue(patient, newPatient);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        }
        Patient saved = patientRepositoy.save(patient);

        return modelMapper.map(saved, PatientDto.class);

    }

    public void isPatientExistById(Long id) {
        boolean exists = patientRepositoy.existsById(id);
        if (!exists) throw new ResourceNotFoundException("Patient not found with ID: " + id);
    }
}
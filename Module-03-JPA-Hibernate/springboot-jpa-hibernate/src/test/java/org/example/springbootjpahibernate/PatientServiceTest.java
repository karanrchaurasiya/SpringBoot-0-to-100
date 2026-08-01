package org.example.springbootjpahibernate;

import org.example.springbootjpahibernate.dto.BloodGroupStats;
import org.example.springbootjpahibernate.dto.cPatientInfo;
import org.example.springbootjpahibernate.dto.iPatientInfo;
import org.example.springbootjpahibernate.entity.Patient;
import org.example.springbootjpahibernate.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatient() {
//        List<iPatientInfo> usingInterface =  patientRepository.getAllPatientsInfo();
//        List<cPatientInfo> usingConcrete =  patientRepository.getAllPatientsInfoConcrete();
//        List<BloodGroupStats> useCount =  patientRepository.getBloodGroupStats();
//
//        for (var p : useCount) {
//            System.out.println(p);
//        }

        int rowsAffected = patientRepository.updatePatientWithId("Rohit Sharma",1L);
        System.out.println(rowsAffected);

    }
}

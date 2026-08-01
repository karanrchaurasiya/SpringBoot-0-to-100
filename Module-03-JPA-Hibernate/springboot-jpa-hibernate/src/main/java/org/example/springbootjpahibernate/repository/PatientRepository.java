package org.example.springbootjpahibernate.repository;

import jakarta.transaction.Transactional;
import org.example.springbootjpahibernate.dto.BloodGroupStats;
import org.example.springbootjpahibernate.dto.cPatientInfo;
import org.example.springbootjpahibernate.dto.iPatientInfo;
import org.example.springbootjpahibernate.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p.id AS id, p.name AS name, p.email AS email FROM Patient p")
    List<iPatientInfo> getAllPatientsInfo();

    @Query("SELECT new org.example.springbootjpahibernate.dto.cPatientInfo(p.id, p.name) FROM Patient p")
    List<cPatientInfo> getAllPatientsInfoConcrete();

    @Query("SELECT new org.example.springbootjpahibernate.dto.BloodGroupStats(p.bloodGroup, COUNT(p))" +
            " FROM Patient p GROUP BY p.bloodGroup ORDER BY COUNT(p) DESC")
    List<BloodGroupStats> getBloodGroupStats();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updatePatientWithId(@Param(value = "name") String name, @Param(value = "id") Long id);

}

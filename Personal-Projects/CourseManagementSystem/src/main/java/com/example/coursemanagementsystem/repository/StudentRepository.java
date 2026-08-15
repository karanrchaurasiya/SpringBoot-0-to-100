package com.example.coursemanagementsystem.repository;

import com.example.coursemanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByEmail(String email);
    List<Student> findByNameContains(String text);
    List<Student> findByName(String text);
    List<Student> findByAgeGreaterThan(Integer age);
    List<Student> findByAgeLessThan(Integer age);
    List<Student> findByAgeBetween(Integer min, Integer max);
    List<Student> findByEmailContaining(String text);

    List<Student> findByNameOrEmail(String text, String email);
    List<Student> findByNameAndAge(String text, Integer age);
    List<Student> findByAgeGreaterThanEqual(Integer age);



}

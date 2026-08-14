package com.example.coursemanagementsystem.controller;

import com.example.coursemanagementsystem.dto.StudentRequest;
import com.example.coursemanagementsystem.dto.StudentResponse;
import com.example.coursemanagementsystem.entity.Student;
import com.example.coursemanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentResponse> saveStudent(@RequestBody @Valid StudentRequest student){
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable Long id,
                                                 @RequestBody @Valid StudentRequest student){
        return ResponseEntity.ok(studentService.updateStudent(student, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.ok(true);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentResponse> updateParialStudent(@PathVariable Long id,
                                                               @RequestBody StudentRequest fieldToUpdate){
        return ResponseEntity.ok(studentService.updateParialStudent(id, fieldToUpdate));
    }


}

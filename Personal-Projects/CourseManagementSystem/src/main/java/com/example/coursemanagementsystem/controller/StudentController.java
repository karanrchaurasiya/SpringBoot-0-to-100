package com.example.coursemanagementsystem.controller;

import com.example.coursemanagementsystem.dto.StudentRequest;
import com.example.coursemanagementsystem.dto.StudentResponse;
import com.example.coursemanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/search")
    public ResponseEntity<StudentResponse> findStudentByEmail(@RequestParam String email){
        return ResponseEntity.ok(studentService.findStudentByEmail(email));
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<StudentResponse>> findStudentByName(@RequestParam String text){
        return ResponseEntity.ok(studentService.findStudentByName(text));
    }

    @GetMapping("/search/older")
    public ResponseEntity<List<StudentResponse>> findByAgeGreaterThan(@RequestParam Integer age){
        List<StudentResponse> studentResponses =  studentService.findByAgeGreaterThan(age);
        if (studentResponses.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentResponses);
    }

    @GetMapping("/search/age-range")
    public ResponseEntity<List<StudentResponse>> findByAgeBetween(
            @RequestParam Integer minAge,
            @RequestParam Integer maxAge){
        List<StudentResponse> studentResponses = studentService.findByAgeBetween(minAge, maxAge);

        if (studentResponses.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentResponses);
    }

    @GetMapping("/search/name-age")
    public ResponseEntity<List<StudentResponse>> findByNameAndAge(
            @RequestParam String name,
            @RequestParam Integer age){

        List<StudentResponse> studentResponses = studentService.findByNameAndAge(name, age);

        if (studentResponses.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentResponses);
    }

}

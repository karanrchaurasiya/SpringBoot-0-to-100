package com.example.coursemanagementsystem.service;

import com.example.coursemanagementsystem.dto.StudentRequest;
import com.example.coursemanagementsystem.dto.StudentResponse;
import com.example.coursemanagementsystem.entity.Student;
import com.example.coursemanagementsystem.exception.StudentNotFoundException;
import com.example.coursemanagementsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public List<StudentResponse> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(element -> modelMapper.map(element, StudentResponse.class))
                .toList();
    }

    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id: " + id +" not found"));

        return modelMapper.map(student, StudentResponse.class);
    }

    public StudentResponse saveStudent(StudentRequest student) {
         Student student1 = modelMapper.map(student, Student.class);
         return modelMapper.map(studentRepository.save(student1), StudentResponse.class);
    }

    public void deleteStudentById(Long id) {
        studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id: " + id +" not found"));
        studentRepository.deleteById(id);
    }

    public StudentResponse updateStudent(StudentRequest student, Long id) {
        Student student1 = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id: " + id +" not found"));

        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setPhone(student.getPhone());
        student1.setEmail(student.getEmail());
        return modelMapper.map(studentRepository.save(student1), StudentResponse.class);
    }


    public StudentResponse updateParialStudent(Long id, StudentRequest fieldToUpdate) {
        Student studentFounded = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id: " + id +" not found"));

        if (fieldToUpdate.getName() != null) studentFounded.setName(fieldToUpdate.getName());
        if (fieldToUpdate.getEmail() != null) studentFounded.setEmail(fieldToUpdate.getEmail());
        if (fieldToUpdate.getAge() != null) studentFounded.setAge(fieldToUpdate.getAge());
        if (fieldToUpdate.getPhone() != null) studentFounded.setPhone(fieldToUpdate.getPhone());

        return modelMapper.map(studentRepository.save(studentFounded), StudentResponse.class);
    }
}

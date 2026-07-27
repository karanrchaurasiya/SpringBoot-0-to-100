package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.EmployeeDto;
import org.example.exceptions.ResourceNotFoundException;
import org.example.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/hello")
    public String helloEmployee() {
        return "Hello World";
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeDto> employeeDto = employeeService.getEmployeeById(id);
        return employeeDto
                .map(employeeDto1 -> ResponseEntity.ok().body(employeeDto1))
                .orElseThrow(() -> new ResourceNotFoundException("Resource with id: " + id + " is not found!"));
    }



    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(@RequestParam(required = false) boolean isActive,
                                                @RequestParam(required = false) String name) {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody @Valid EmployeeDto insertEmployee) {
        return new ResponseEntity<>(employeeService.createNewEmployee(insertEmployee), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeAndAdd(@PathVariable Long id, @RequestBody @Valid EmployeeDto insertEmployee) {
       return ResponseEntity.ok(employeeService.updateEmployeeAndAdd(id,insertEmployee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmployeeById(id);
        if (deleted) return ResponseEntity.ok(true);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDto> updatePartialEmployeeById(@PathVariable Long id, @RequestBody Map<String, Object> updateData) {
        EmployeeDto employeeDto = employeeService.updatePartialEmployeeById(id,updateData);
        if (employeeDto == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(employeeDto);
    }
}

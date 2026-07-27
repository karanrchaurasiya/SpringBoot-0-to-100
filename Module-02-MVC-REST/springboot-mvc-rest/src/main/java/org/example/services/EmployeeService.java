package org.example.services;

import org.example.dto.EmployeeDto;
import org.example.entitiy.EmployeeEntity;
import org.example.exceptions.ResourceNotFoundException;
import org.example.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDto> getEmployeeById(Long id) {
       return employeeRepository.findById(id)
               .map(employee -> modelMapper.map(employee, EmployeeDto.class));
    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employeeEntities =  employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class))
                .toList();
    }

    public EmployeeDto createNewEmployee(EmployeeDto insertEmployee) {
        EmployeeEntity employeeEntity = employeeRepository.save(modelMapper.map(insertEmployee, EmployeeEntity.class));
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    public void isEmployeeExistsById(Long id) {
        boolean exists = employeeRepository.existsById(id);
        if (!exists) throw new ResourceNotFoundException("Employee not found with ID: " + id);
    }


    public EmployeeDto updateEmployeeAndAdd(Long id, EmployeeDto insertEmployee) {
        isEmployeeExistsById(id);

        EmployeeEntity employeeEntity =  modelMapper.map(insertEmployee, EmployeeEntity.class);
        employeeEntity.setId(id);
        employeeRepository.save(employeeEntity);
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }


    public boolean deleteEmployeeById(Long id) {
        isEmployeeExistsById(id);
        employeeRepository.deleteById(id);
        return true;
    }


    public EmployeeDto updatePartialEmployeeById(Long id, Map<String, Object> updateData) {
        isEmployeeExistsById(id);

        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        updateData.forEach((field,value)->{
           Field fieldToUpdate = ReflectionUtils.getRequiredField(EmployeeEntity.class, field);
           fieldToUpdate.setAccessible(true);
           ReflectionUtils.setField(fieldToUpdate, employeeEntity ,value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDto.class);

    }
}

package com.backend.demo.controller;

import com.backend.demo.exception.ResourceNotFoundException;
import com.backend.demo.model.Employees;
import com.backend.demo.model.Jobs;
import com.backend.demo.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeesController {
    @Autowired
    private EmployeesRepository employeesRepository;
    /********************************************************************************************/
    @GetMapping("/employees")
    public List<Employees> getEmployees() {
        return employeesRepository.findAll();
    }
    /********************************************************************************************/
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employees> getEmployeesById(@PathVariable(value = "id") Long employeesId)
        throws ResourceNotFoundException {
        Employees employees = employeesRepository.findById(employeesId)
        .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado para el Id :: " + employeesId));
        return ResponseEntity.ok().body(employees);
    }
    /********************************************************************************************/
    @PostMapping("/employees")
    public Employees createEmployees(@Valid @RequestBody Employees employees) {
        return employeesRepository.save(employees);
    }
    /********************************************************************************************/
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employees> updateEmployees(@PathVariable(value = "id") Long employeesId,
        @Valid @RequestBody Employees employeesDetails) throws ResourceNotFoundException {
        Employees employees = employeesRepository.findById(employeesId)
        .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado para el Id :: " + employeesId));

        employees.setGendersId(employeesDetails.getGendersId());
        employees.setJobsId(employeesDetails.getJobsId());
        employees.setName(employeesDetails.getName());
        employees.setLast_name(employeesDetails.getLast_name());
        employees.setBirthdate(employeesDetails.getBirthdate());

        final Employees updatedEmployees = employeesRepository.save(employees);
        return ResponseEntity.ok(updatedEmployees);
    }
    /********************************************************************************************/
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployees(@PathVariable(value = "id") Long employeesId)
        throws ResourceNotFoundException {
        Employees employees = employeesRepository.findById(employeesId)
        .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado para el Id :: " + employeesId));
        employeesRepository.delete(employees);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Borrado", Boolean.TRUE);
        return response;
    }
    /********************************************************************************************/
}

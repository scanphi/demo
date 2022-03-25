package com.backend.demo.controller;

import com.backend.demo.response.ResponsePost;
import com.backend.demo.exception.ResourceNotFoundException;
import com.backend.demo.model.EmployeeWorkedHours;
import com.backend.demo.repository.EmployeeWorkedHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeWorkedHoursController {
    @Autowired
    private EmployeeWorkedHoursRepository employeeWorkedHoursRepository;
    /********************************************************************************************/
    @GetMapping("/employeeworkedhours")
    public List<EmployeeWorkedHours> getEmployeeWorkedHours() {
        return employeeWorkedHoursRepository.findAll();
    }
    /********************************************************************************************/
    @GetMapping("/employeeworkedhours/{id}")
    public ResponseEntity<EmployeeWorkedHours> getEmployeeWorkedHoursById(@PathVariable(value = "id") Long employeeWorkedHoursId)
        throws ResourceNotFoundException {
        EmployeeWorkedHours employeeWorkedHours = employeeWorkedHoursRepository.findById(employeeWorkedHoursId)
        .orElseThrow(() -> new ResourceNotFoundException("Horas de trabajo no encontrado para el Id :: " + employeeWorkedHoursId));
        return ResponseEntity.ok().body(employeeWorkedHours);
    }
    /********************************************************************************************/
    @PostMapping("/employeeworkedhours")
    public ResponsePost createEmployeeWorkedHours(@Valid @RequestBody EmployeeWorkedHours employeeWorkedHours) {
        ResponsePost responsePost = new ResponsePost();
        BigDecimal horasPermitidas = new BigDecimal(20);
        try{
            System.out.println("\n\n\n\n\n\n"+(employeeWorkedHours.getWorkedHours().compareTo(horasPermitidas))+"\n\n\n\n\n\n");
            int comparacion = (employeeWorkedHours.getWorkedHours().compareTo(horasPermitidas));
            if(comparacion==0||comparacion==-1){
                employeeWorkedHoursRepository.save(employeeWorkedHours);
                responsePost.setId(employeeWorkedHours.getEmployeeWorkedHoursId());
                responsePost.setSuccess(Boolean.TRUE);
            }else{
                responsePost.setId(null);
                responsePost.setSuccess(Boolean.FALSE);
            }
        }catch (DataAccessException ex){
            responsePost.setId(null);
            responsePost.setSuccess(Boolean.FALSE);
        }
        return responsePost;
    }
    /********************************************************************************************/
    @PutMapping("/employeeworkedhours/{id}")
    public ResponseEntity<EmployeeWorkedHours> updateEmployeeWorkedHours(@PathVariable(value = "id") Long employeeWorkedHoursId,
        @Valid @RequestBody EmployeeWorkedHours employeeWorkedHoursDetails) throws ResourceNotFoundException {
        EmployeeWorkedHours employeeWorkedHours = employeeWorkedHoursRepository.findById(employeeWorkedHoursId)
        .orElseThrow(() -> new ResourceNotFoundException("Horas de trabajo no encontrado para el Id :: " + employeeWorkedHoursId));

        employeeWorkedHours.setEmployeesId(employeeWorkedHoursDetails.getEmployeesId());
        employeeWorkedHours.setWorkedHours(employeeWorkedHoursDetails.getWorkedHours());
        employeeWorkedHours.setWorkedDate(employeeWorkedHoursDetails.getWorkedDate());

        final EmployeeWorkedHours updatedEmployeeWorkedHours = employeeWorkedHoursRepository.save(employeeWorkedHours);
        return ResponseEntity.ok(updatedEmployeeWorkedHours);
    }
    /********************************************************************************************/
    @DeleteMapping("/employeeworkedhours/{id}")
    public Map<String, Boolean> deleteEmployees(@PathVariable(value = "id") Long employeeWorkedHoursId)
        throws ResourceNotFoundException {
        EmployeeWorkedHours employeeWorkedHours = employeeWorkedHoursRepository.findById(employeeWorkedHoursId)
        .orElseThrow(() -> new ResourceNotFoundException("Horas de trabajo no encontrado para el Id :: " + employeeWorkedHoursId));
        employeeWorkedHoursRepository.delete(employeeWorkedHours);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Borrado", Boolean.TRUE);
        return response;
    }
    /********************************************************************************************/
}

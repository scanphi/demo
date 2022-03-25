package com.backend.demo.controller;

import com.backend.demo.exception.ResourceNotFoundException;
import com.backend.demo.model.Jobs;
import com.backend.demo.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class JobsController {
    @Autowired
    private JobsRepository jobsRepository;
    /********************************************************************************************/
    @GetMapping("/jobs")
    public List<Jobs> getJobs() {
        return jobsRepository.findAll();
    }
    /********************************************************************************************/
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Jobs> getJobsById(@PathVariable(value = "id") Long jobsId)
        throws ResourceNotFoundException {
        Jobs jobs = jobsRepository.findById(jobsId)
        .orElseThrow(() -> new ResourceNotFoundException("Trabajo no encontrado para el Id :: " + jobsId));
        return ResponseEntity.ok().body(jobs);
    }
    /********************************************************************************************/
    @PostMapping("/jobs")
    public Jobs createJobs(@Valid @RequestBody Jobs jobs) {
        return jobsRepository.save(jobs);
    }
    /********************************************************************************************/
    @PutMapping("/jobs/{id}")
    public ResponseEntity<Jobs> updateJobs(@PathVariable(value = "id") Long jobsId,
        @Valid @RequestBody Jobs jobsDetails) throws ResourceNotFoundException {
        Jobs jobs = jobsRepository.findById(jobsId)
        .orElseThrow(() -> new ResourceNotFoundException("Trabajo no encontrado para el Id :: " + jobsId));
        jobs.setName(jobsDetails.getName());
        jobs.setSalary(jobsDetails.getSalary());
        final Jobs updatedJobs = jobsRepository.save(jobs);
        return ResponseEntity.ok(updatedJobs);
    }
    /********************************************************************************************/
    @DeleteMapping("/jobs/{id}")
    public Map<String, Boolean> deleteJobs(@PathVariable(value = "id") Long jobsId)
        throws ResourceNotFoundException {
        Jobs jobs = jobsRepository.findById(jobsId)
        .orElseThrow(() -> new ResourceNotFoundException("Trabajo no encontrado para el Id :: " + jobsId));
        jobsRepository.delete(jobs);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Borrado", Boolean.TRUE);
        return response;
    }
    /********************************************************************************************/
    @GetMapping("/jobs/byname/{jobName}")
    public ResponseEntity<Jobs> getJobsByName(@PathVariable(value = "jobName") String jobName)
        throws ResourceNotFoundException {
        Jobs jobs = jobsRepository.getJobsByName(jobName);
        return ResponseEntity.ok().body(jobs);
    }
    /********************************************************************************************/
}

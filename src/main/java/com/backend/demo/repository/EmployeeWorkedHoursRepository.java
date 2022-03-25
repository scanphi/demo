package com.backend.demo.repository;

import com.backend.demo.model.EmployeeWorkedHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeWorkedHoursRepository extends JpaRepository<EmployeeWorkedHours, Long> {
}

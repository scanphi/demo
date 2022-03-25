package com.backend.demo.repository;

import com.backend.demo.model.EmployeeWorkedHours;
import com.backend.demo.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EmployeeWorkedHoursRepository extends JpaRepository<EmployeeWorkedHours, Long> {
    boolean existsByEmployeesIdAndWorkedDate(Employees employeesId, Date workedDate);
}

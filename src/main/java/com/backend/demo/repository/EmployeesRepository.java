package com.backend.demo.repository;

import com.backend.demo.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    boolean existsByNameAndLastName(String name, String lastName);

    @Query(value="select * from employees a where a.name= :name and a.last_name= :lastName limit 1 offset 0", nativeQuery=true)
    Employees getEmployeesValidated(String name, String lastName);
}

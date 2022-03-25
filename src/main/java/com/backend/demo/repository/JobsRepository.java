package com.backend.demo.repository;

import com.backend.demo.model.Employees;
import com.backend.demo.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobsRepository extends JpaRepository<Jobs, Long> {
    @Query(value="select * from jobs a where a.name= :name limit 1 offset 0", nativeQuery=true)
    Jobs getJobsByName(String name);
}

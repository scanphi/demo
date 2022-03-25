package com.backend.demo.repository;

import com.backend.demo.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs, Long> {
}

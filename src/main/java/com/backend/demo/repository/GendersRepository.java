package com.backend.demo.repository;

import com.backend.demo.model.Genders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GendersRepository extends JpaRepository<Genders, Long> {
}

package com.sgic.SchoolManagement.repository;

import com.sgic.SchoolManagement.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {

    // get school details using param
    List<School> findByNameContainingIgnoreCase(String name);
}

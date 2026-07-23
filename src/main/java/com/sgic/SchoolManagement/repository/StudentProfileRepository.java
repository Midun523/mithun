package com.sgic.SchoolManagement.repository;

import com.sgic.SchoolManagement.entities.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
}

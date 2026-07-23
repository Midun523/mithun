package com.sgic.SchoolManagement.repository;

import com.sgic.SchoolManagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

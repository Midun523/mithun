package com.sgic.SchoolManagement.repository;

import com.sgic.SchoolManagement.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

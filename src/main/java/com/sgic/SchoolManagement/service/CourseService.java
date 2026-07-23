package com.sgic.SchoolManagement.service;

import com.sgic.SchoolManagement.dtos.CourseDto;
import com.sgic.SchoolManagement.entities.Course;

public interface CourseService {
    Course saveCourse(CourseDto courseDto);

    void deleteCourse(Long id);

}

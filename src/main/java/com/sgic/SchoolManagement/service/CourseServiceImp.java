package com.sgic.SchoolManagement.service;

import com.sgic.SchoolManagement.dtos.CourseDto;
import com.sgic.SchoolManagement.entities.Course;
import com.sgic.SchoolManagement.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    //post
    @Override
    public Course saveCourse(CourseDto courseDto) {

        Course course = new Course();

        course.setCourseName(courseDto.getCourseName());

        return courseRepository.save(course);
    }

    //delete
    @Override
    public void deleteCourse(Long id) {

        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Student Not Found");
        }

        courseRepository.deleteById(id);
    }
}
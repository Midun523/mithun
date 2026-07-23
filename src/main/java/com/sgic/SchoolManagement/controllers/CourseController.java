package com.sgic.SchoolManagement.controllers;

import com.sgic.SchoolManagement.dtos.CourseDto;
import com.sgic.SchoolManagement.entities.Course;
import com.sgic.SchoolManagement.service.CourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course saveCourse(@RequestBody CourseDto courseDto) {
        return courseService.saveCourse(courseDto);
    }

    //delete
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {

        courseService.deleteCourse(id);
        return "Student deleted successfully";
    }
}
package com.sgic.SchoolManagement.controllers;

import com.sgic.SchoolManagement.dtos.StudentDto;
import com.sgic.SchoolManagement.entities.Student;
import com.sgic.SchoolManagement.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){

        this.studentService = studentService;
    }

    //post
    @PostMapping
    public Student saveStudent(@RequestBody StudentDto studentDto){

        return studentService.saveStudent(studentDto);
    }

    //delete
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }
}

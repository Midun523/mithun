package com.sgic.SchoolManagement.service;

import com.sgic.SchoolManagement.dtos.StudentDto;
import com.sgic.SchoolManagement.entities.Student;

public interface StudentService {

    //post
    Student saveStudent(StudentDto studentDto);

    //delete
    void deleteStudent(Long id);
}

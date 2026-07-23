package com.sgic.SchoolManagement.service;

import com.sgic.SchoolManagement.dtos.StudentDto;
import com.sgic.SchoolManagement.entities.Course;
import com.sgic.SchoolManagement.entities.Student;
import com.sgic.SchoolManagement.entities.School;
import com.sgic.SchoolManagement.repository.CourseRepository;
import com.sgic.SchoolManagement.repository.SchoolRepository;
import com.sgic.SchoolManagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;
    private final CourseRepository courseRepository;

    public StudentServiceImp(StudentRepository studentRepository, SchoolRepository schoolRepository, CourseRepository courseRepository){

        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
        this.courseRepository = courseRepository;
    }

    //post
    @Override
    public Student saveStudent(StudentDto studentDto) {

        Student student = new Student();

        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());

        // Get school
        School school = schoolRepository.findById(studentDto.getSchoolId())
                .orElseThrow(() -> new RuntimeException("School Not Found"));

        student.setSchool(school);

        // Get courses
        List<Course> courses = courseRepository.findAllById(studentDto.getCourseIds());

        // Set many-to-many relationship
        student.setCourses(courses);

        return studentRepository.save(student);
    }

    //delete
    @Override
    public void deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student Not Found");
        }

        studentRepository.deleteById(id);
    }
}

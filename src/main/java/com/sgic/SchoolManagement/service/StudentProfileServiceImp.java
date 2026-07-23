package com.sgic.SchoolManagement.service;

import com.sgic.SchoolManagement.entities.Student;
import com.sgic.SchoolManagement.dtos.StudentProfileDto;
import com.sgic.SchoolManagement.entities.StudentProfile;
import com.sgic.SchoolManagement.repository.StudentProfileRepository;
import com.sgic.SchoolManagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileServiceImp implements StudentProfileService{

    private final StudentProfileRepository studentProfileRepository;
    private final StudentRepository studentRepository;

    public StudentProfileServiceImp(StudentProfileRepository studentProfileRepository, StudentRepository studentRepository){
        this.studentProfileRepository = studentProfileRepository;
        this.studentRepository = studentRepository;
    }

    //post
    @Override
    public StudentProfile saveProfile(StudentProfileDto studentProfileDto){

        StudentProfile studentProfile = new StudentProfile();

        studentProfile.setBio(studentProfileDto.getBio());

        //get student using student id
        Student student = studentRepository.findById(studentProfileDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student Not Found"));

        studentProfile.setStudent(student);

        return studentProfileRepository.save(studentProfile);
    }

    //delete
    @Override
    public void deleteProfile(Long id) {

        if (!studentProfileRepository.existsById(id)) {
            throw new RuntimeException("Student Profile Not Found");
        }

        studentProfileRepository.deleteById(id);
    }
}

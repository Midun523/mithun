package com.sgic.SchoolManagement.controllers;

import com.sgic.SchoolManagement.dtos.StudentProfileDto;
import com.sgic.SchoolManagement.entities.StudentProfile;
import com.sgic.SchoolManagement.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentprofile")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService){
        this.studentProfileService = studentProfileService;
    }

    //post
    @PostMapping
    public StudentProfile saveProfile(@RequestBody StudentProfileDto studentProfileDto){
        return studentProfileService.saveProfile(studentProfileDto);
    }

    //delete
    @DeleteMapping("/{id}")
    public String deleteProfile(@PathVariable Long id) {

        studentProfileService.deleteProfile(id);
        return "Student deleted successfully";
    }

}

package com.sgic.SchoolManagement.service;

import com.sgic.SchoolManagement.dtos.StudentProfileDto;
import com.sgic.SchoolManagement.entities.StudentProfile;

public interface StudentProfileService {

    //post
    StudentProfile saveProfile(StudentProfileDto studentProfileDto);

    //delete
    void deleteProfile(Long id);
}

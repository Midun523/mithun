package com.sgic.SchoolManagement.service;

import com.sgic.SchoolManagement.dtos.SchoolDto;
import com.sgic.SchoolManagement.entities.School;

import java.util.List;

public interface SchoolService {

    //post
    School saveSchool(SchoolDto schoolDto);

    //Get using path variable
    School getSchoolById(Long id);

    //get using param
    List<School> searchSchool(String name);

    //Put
    School updateSchool(Long id, SchoolDto schoolDto);

    //delete
    void deleteSchool(Long id);
}

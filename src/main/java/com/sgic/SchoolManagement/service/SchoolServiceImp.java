package com.sgic.SchoolManagement.service;

import com.sgic.SchoolManagement.dtos.SchoolDto;
import com.sgic.SchoolManagement.entities.School;
import com.sgic.SchoolManagement.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImp implements SchoolService{

    private final SchoolRepository schoolRepository;

    public SchoolServiceImp(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }


    //post
    @Override
    public School saveSchool(SchoolDto schoolDto) {

        School school = new School();

        school.setName(schoolDto.getName());

        return schoolRepository.save(school);
    }

    //get using id
    @Override
    public School getSchoolById(Long id) {

        return schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School Not Found"));

    }

    //get using param
    @Override
    public List<School> searchSchool(String name) {

        return schoolRepository.findByNameContainingIgnoreCase(name);
    }

    //put
    @Override
    public School updateSchool(Long id, SchoolDto schoolDto) {

        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School Not Found"));

        school.setName(schoolDto.getName());

        return schoolRepository.save(school);
    }

    //delete
    @Override
    public void deleteSchool(Long id){

        if(!schoolRepository.existsById(id)){
            throw new RuntimeException("School Not found");
        }

        schoolRepository.deleteById(id);
    }
}

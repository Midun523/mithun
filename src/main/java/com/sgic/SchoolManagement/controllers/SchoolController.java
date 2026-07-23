package com.sgic.SchoolManagement.controllers;

import com.sgic.SchoolManagement.dtos.SchoolDto;
import com.sgic.SchoolManagement.entities.School;
import com.sgic.SchoolManagement.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService){

        this.schoolService = schoolService;
    }

    //post
    @PostMapping
    public School saveSchool(@RequestBody SchoolDto schoolDto){

        return schoolService.saveSchool(schoolDto);
    }

    //get using id
    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable Long id) {

        return schoolService.getSchoolById(id);
    }

    //get using param
    @GetMapping("/search")
    public List<School> searchSchool(
            @RequestParam String name) {

        return schoolService.searchSchool(name);
    }

    //put
    @PutMapping("/{id}")
    public School updateSchool(@PathVariable Long id, @RequestBody SchoolDto schoolDto) {

        return schoolService.updateSchool(id, schoolDto);
    }

    //delete
    @DeleteMapping("/{id}")
    public String deleteSchool(@PathVariable Long id){
        schoolService.deleteSchool(id);
        return "School Delete Successfully!";
    }
}

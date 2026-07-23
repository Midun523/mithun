package com.sgic.SchoolManagement.controllers;

import com.sgic.SchoolManagement.service.SchoolSystemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolSystemControllers {

    private final SchoolSystemService schoolSystemService;

    public SchoolSystemControllers(SchoolSystemService schoolSystemService){
        this.schoolSystemService = schoolSystemService;
    }

    @GetMapping("/print")
    public String print(){
        return schoolSystemService.getAppInfo();
    }
}

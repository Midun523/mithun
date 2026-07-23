package com.sgic.SchoolManagement.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CourseDto {

    private String courseName;

    //Many To Many(Student)
    private List<Long> studentIds;
}

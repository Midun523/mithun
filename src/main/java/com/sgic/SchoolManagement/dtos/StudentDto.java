package com.sgic.SchoolManagement.dtos;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {

    private String firstName;
    private String lastName;
    private String email;
    private Integer age;

    //FK(School)
    private Long schoolId;

    // Many-to-Many(Course)
    private List<Long> courseIds;

}

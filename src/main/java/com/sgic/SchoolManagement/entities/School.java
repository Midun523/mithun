package com.sgic.SchoolManagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;


    //school <--> student
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL,
    fetch=FetchType.LAZY)
    private List<Student> students;


}

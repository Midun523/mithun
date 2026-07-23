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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(unique = true)
    private String email;

    private Integer age;

    //school <--> student
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private School school;

    //student <--> studentProfile
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL,
            fetch=FetchType.LAZY)
    private StudentProfile studentProfile;

    //student <--> course
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name ="course_id")
    )
    private List<Course> courses;
}

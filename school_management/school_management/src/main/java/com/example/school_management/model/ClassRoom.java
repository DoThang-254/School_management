package com.example.school_management.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "classroom")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(name = "grade", nullable = false)
    private int grade;

    @Column(name = "school_year", nullable = false)
    private String schoolYear;

    @OneToMany(mappedBy = "classRoom" , fetch = FetchType.LAZY)
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(mappedBy = "classRoom" , fetch = FetchType.LAZY)
    private List<HeadingBook> headingBooks;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
}

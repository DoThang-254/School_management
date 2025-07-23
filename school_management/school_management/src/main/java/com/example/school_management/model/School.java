package com.example.school_management.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long schoolId;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "school_address")
    private String schoolAddress;

    @Column(name = "school_email")
    private String schoolEmail;

    @Column(name = "school_phone")
    private String schoolPhone;

    @OneToMany(mappedBy = "school")
    private List<ClassRoom> classRoom;

    @OneToMany(mappedBy = "school")
    private List<Student> student;

    @OneToMany(mappedBy = "school")
    private List<Staff> staffs;
}

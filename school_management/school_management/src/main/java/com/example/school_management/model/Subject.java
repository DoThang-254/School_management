package com.example.school_management.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subjectId;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "subject_description")
    private String subjectDescription;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @OneToMany(mappedBy = "subject")
    private List<MarkCard>  markCard ;

    @OneToMany(mappedBy = "subject")
    private List<MarkReport> markReport;
}

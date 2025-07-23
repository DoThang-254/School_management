package com.example.school_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "markreport")
public class MarkReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long markReportId;

    @Column(name = "semester")
    private String semester;

    @Column(name = "mark")
    private int mark;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}

package com.example.school_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ReportBook")
public class ReportBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportBookId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
}

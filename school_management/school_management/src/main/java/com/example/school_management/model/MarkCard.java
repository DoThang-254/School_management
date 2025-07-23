package com.example.school_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MarkCard")
public class MarkCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long markCardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}

package com.example.school_management.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;


    @OneToOne(mappedBy = "student"
            , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private StudentCard studentCard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent ;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
        private ClassRoom classRoom;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MarkCard> markCard;

    @OneToOne(mappedBy = "student" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ReportBook reportBook;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(mappedBy = "student")
    private List<MarkReport> markReport ;

}

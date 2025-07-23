package com.example.school_management.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;

import java.util.List;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long staffId ;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "staff")
    private List<ClassRoom> staffList;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(mappedBy = "staff")
    private List<HeadingBook> headingBooks ;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "staff")
    private List<ReportBook> reportBooks;

    @OneToMany(mappedBy = "staff")
    private List<Subject> subject;
}

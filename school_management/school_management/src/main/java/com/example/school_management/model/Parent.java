package com.example.school_management.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long parentId;

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "parent" ,
            fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST, CascadeType.MERGE ,
            CascadeType.DETACH , CascadeType.REFRESH})
    private List<Student> student;


    @OneToMany(mappedBy = "parent" , fetch = FetchType.LAZY)
    private List<ReportBook>  reportBooks ;
}

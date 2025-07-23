package com.example.school_management.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username ;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone ;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address ;

    @Column(name = "gender")
    private boolean gender ;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToOne(mappedBy = "account")
    private Student student;

    @OneToOne(mappedBy = "account")
    private Parent parent;

    @OneToOne(mappedBy = "account")
    private Staff staff;
}

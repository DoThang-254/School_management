package com.example.school_management.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "StudentCard")
public class StudentCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardId;

    @Column(name = "photo")
    private String photo;

    @Column(name = "createDate")
    private Date createDate ;

    @Column(name = "endDate")
    private Date endDate ;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student ;

}

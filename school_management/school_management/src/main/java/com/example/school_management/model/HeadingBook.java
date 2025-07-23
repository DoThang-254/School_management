package com.example.school_management.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "headingbook")
public class HeadingBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long headingBookId;

    @Column(name = "start_date")
    private Date startDate ;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassRoom classRoom;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
}

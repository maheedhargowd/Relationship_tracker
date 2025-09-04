package com.relationtracker.backend.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id" , nullable=false)
    private Long Id;

    @OneToMany(mappedBy="user")
    private List<Relationship> relationships;

    @Column(name="user_name",nullable=false)
    private String userName;

    @Column(name="age")
    private Double age;

    @Column(name="mail_id",nullable=false)
    private String mailId;



}

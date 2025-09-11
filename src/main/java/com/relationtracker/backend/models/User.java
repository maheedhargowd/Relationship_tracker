package com.relationtracker.backend.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


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

    // No-args constructor
    public User() {}

    // Getters and Setters
    public Long getId() { return Id; }
    public void setId(Long id) { this.Id = Id; }

    public List<Relationship> getRelationships() { return relationships; }
    public void setRelationships(List<Relationship> relationships) { this.relationships = relationships; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public Double getAge() { return age; }
    public void setAge(Double age) { this.age = age; }

    public String getMailId() { return mailId; }
    public void setMailId(String mailId) { this.mailId = mailId; }



}

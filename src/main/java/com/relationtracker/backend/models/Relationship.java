package com.relationtracker.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="relationships")
public class Relationship {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="relationship_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="relationship_type",nullable=false)
    private String relationshipType;

    @Column(name="relationship_name")
    private String realtionshipName;

    @Column(name="relationship_age")
    private Double relationshipAge;




}

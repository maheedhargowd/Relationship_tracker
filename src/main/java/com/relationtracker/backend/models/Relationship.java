package com.relationtracker.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
    private String relationshipName;

    @Column(name="relationship_age")
    private Double relationshipAge;


    //no arguement constructor 
    public Relationship(){};

    //getters

    public User getUser() {
        return user;
    }

    public Long getId(){
        return id;
    }
    public String  relationshipType(){
        return relationshipType;
    }
    public String relationshipName(){
        return relationshipName;
    }
    public Double relationshipAge(){
        return relationshipAge;
    }

        //setters
    public void setUser(User user) {
            this.user = user;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setRelationshipType(String relationshipType){
        this.relationshipType = relationshipType;
    }
    public void setRelationshipName(String relationshipName){
        this.relationshipName = relationshipName;
    }
    public void setRelationshipAge(Double relationshipAge){
        this.relationshipAge = relationshipAge;
    }



}

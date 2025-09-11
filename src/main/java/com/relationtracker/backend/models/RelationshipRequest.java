package com.relationtracker.backend.models;

public class RelationshipRequest {
    private String relationshipType;
    private String relationshipName;
    private Double relationshipAge;
    private Long userId;

    // Getter and Setter for relationshipType
    public String getRelationshipType() {
        return relationshipType;
    }
    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    // Getter and Setter for relationshipName
    public String getRelationshipName() {
        return relationshipName;
    }
    public void setRelationshipName(String relationshipName) {
        this.relationshipName = relationshipName;
    }

    // Getter and Setter for relationshipAge
    public Double getRelationshipAge() {
        return relationshipAge;
    }
    public void setRelationshipAge(Double relationshipAge) {
        this.relationshipAge = relationshipAge;
    }

    // Getter and Setter for userId
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

package com.relationtracker.backend.models;

public class UserUpdateRequest {
    
    private String userName;
    private Double age;
    private String mailId;

    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }


    public Double getAge(){
        return this.age;
    }
    public void setAge(Double age){
        this.age = age;
    }

    
    public String getMailId(){
        return this.mailId;
    }
    public void setMailId(String mailId){
        this.mailId = mailId;
    }

}

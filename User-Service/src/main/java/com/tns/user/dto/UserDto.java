package com.tns.user.dto;


public class UserDto {
    private String id;
    private String name;
    private String contactNo;
    private String email;

    public UserDto() {
    }

    public UserDto(String id, String name, String contactNo, String email) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



package com.example.cafesystem;


public class StaffVM {
    private String firstName;
    private String lastName;
    private String email;
    private String isActive;
    private String isDeleted;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    private String createdDate;

    public StaffVM(String fName, String lName, String email,
                   String isActive, String isDeleted, String createdDate){
        this.firstName = fName;
        this.lastName = lName;
        this.email = email;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.createdDate = createdDate;
    }
}

package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Person;

import java.time.LocalDate;
import java.util.UUID;

public class CustomerViewModel extends Person {
    public CustomerViewModel(UUID id, String fName, String lName,
                             String password, String address,
                             String email, boolean isActive, boolean isDeleted,
                             LocalDate createdDate, UUID createdBy){
        super(id, fName, lName, password, address, email, isDeleted,  isActive, createdDate, createdBy);
    }
}

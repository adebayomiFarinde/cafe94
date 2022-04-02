package com.example.cafesystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This class represents a Customer. (customerId,fName,lName,password,address,email,isActive,isDeleted,
 * createdDate,createdBy)
 */
//customers can use the system
//to make bookings and view information about the menus etc.
public class Customer extends  Person {
    public Customer(UUID customerId, String fName, String lName, String password, String address, String email, boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy) {
        super(customerId, fName, lName, password, address, email, isActive, isDeleted, createdDate, createdBy);
    }
}

package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Person;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a View Model for the Customer class.
 */

public class CustomerViewModel extends Person {

    /**
     * Create a Customer with the following attributes:
     * @param id  The id component.
     * @param fName The first name component.
     * @param lName The last name component.
     * @param password The password component.
     * @param address The address component.
     * @param email The email component.
     * @param isActive Whether it is active or not.
     * @param isDeleted Whether it is deleted or not.
     * @param createdDate The creation Date.
     * @param createdBy Who created the Person instance.
     */
    public CustomerViewModel(UUID id, String fName, String lName,
                             String password, String address,
                             String email, boolean isActive, boolean isDeleted,
                             LocalDate createdDate, UUID createdBy){
        super(id, fName, lName, password, address, email, isDeleted,  isActive, createdDate, createdBy);
    }
}

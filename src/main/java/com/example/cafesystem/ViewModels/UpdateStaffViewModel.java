package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Person;
import com.example.cafesystem.ViewModels.Enum.Portfolio;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a View Model for the Staff class. Assists in updating the Staff members.
 */

public class UpdateStaffViewModel extends Person {
    public Portfolio portfolio;

    /**
     * Create a staff member with the following attributes:
     * @param id The id component.
     * @param fName The first name component.
     * @param lName The last name component.
     * @param password The password component.
     * @param address The address component.
     * @param portfolio The portfolio component.
     * @param email The email component.
     * @param isActive  Whether it is active or not.
     * @param isDeleted Whether it is deleted or not.
     * @param createdDate The creation Date.
     * @param createdBy Who created the Person instance.
     */
    public UpdateStaffViewModel(UUID id, String fName, String lName,
                                String password, String address, Portfolio portfolio,
                                String email, boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy){
        super(id, fName, lName, password, address, email,  isDeleted,  isActive, createdDate, createdBy);
        this.portfolio = portfolio;
    }

    /**
     * get the portfolio component.
     * @return The portfolio.
     */
    public Portfolio getPortfolio() {
        return portfolio;
    }

    /**
     * Set the  portfolio component.
     * @param portfolio The new portfolio.
     */
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}

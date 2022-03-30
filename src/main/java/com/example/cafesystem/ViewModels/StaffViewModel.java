package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Person;
import com.example.cafesystem.ViewModels.Enum.Portfolio;

import java.time.LocalDate;
import java.util.UUID;

public class StaffViewModel extends Person {
    public Portfolio portfolio;

    public StaffViewModel(UUID id, String fName, String lName, String password,
                          String address, Portfolio portfolio, String email, boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy){
        super(id, fName, lName, password, address, email, isDeleted,  isActive, createdDate, createdBy);
        this.portfolio = portfolio;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}

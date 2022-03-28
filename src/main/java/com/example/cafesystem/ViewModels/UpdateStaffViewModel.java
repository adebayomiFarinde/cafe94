package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Person;
import com.example.cafesystem.ViewModels.Enum.Portfolio;

import java.util.UUID;

public class UpdateStaffViewModel extends Person {
    public Portfolio portfolio;

    public UpdateStaffViewModel(UUID id, String fName, String lName, String password, String address, Portfolio portfolio, String email) {
        super(id, fName, lName, password, address, email);
        this.portfolio = portfolio;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}

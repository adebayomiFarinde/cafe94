package com.example.cafesystem.Services;

import java.util.UUID;

public abstract class IUserService {
    public abstract boolean customerLogin(String email, String password);
    public abstract boolean adminLogin(String email, String password);
    public abstract UUID createCustomer(String fName, String lName, String email);
    public abstract UUID createAdmin(String fName, String lName, String email);
    public abstract boolean deleteCustomer(String email);
    public abstract boolean deleteStaff(String email);
}

package com.example.cafesystem.Repository;

import com.example.cafesystem.Customer;
import com.example.cafesystem.ViewModels.CustomerViewModel;
import com.example.cafesystem.ViewModels.UpdateCustomerViewModel;

import java.util.UUID;

public abstract class ICustomerRepository {
    public abstract UUID createCustomer(CustomerViewModel customer);
    public abstract void updateCustomer(UUID customerId, UpdateCustomerViewModel customer);
    public abstract void deleteCustomer(UUID customerId);
    public abstract Customer getCustomerId(UUID customerId);
    public abstract Customer getCustomerByEmailPassword(String email, String password);
}

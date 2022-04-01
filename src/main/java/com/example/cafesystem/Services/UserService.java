package com.example.cafesystem.Services;

import com.example.cafesystem.Customer;
import com.example.cafesystem.Repository.ICustomerRepository;
import com.example.cafesystem.Repository.IStaffRepository;
import com.example.cafesystem.Staff;
import com.example.cafesystem.ViewModels.CustomerViewModel;
import com.example.cafesystem.ViewModels.Enum.Portfolio;
import com.example.cafesystem.ViewModels.StaffViewModel;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class UserService extends IUserService {
    private ICustomerRepository _customerRepository;
    private IStaffRepository _staffRepository;
    public UserService(ICustomerRepository customerRepository,
                       IStaffRepository staffRepository) {
        _customerRepository = customerRepository;
        _staffRepository = staffRepository;
    }
    @Override
    public boolean customerLogin(String email, String password) {
        Customer customer = _customerRepository.getCustomerByEmailPassword(email.toLowerCase(Locale.ROOT), password);

        if(customer == null){
            return false;
        }
        else if(!customer.getIsDeleted() && customer.getActive()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean adminLogin(String email, String password) {
        Staff staff = _staffRepository.getStaffByEmailPassword(email.toLowerCase(Locale.ROOT), password);

        if(staff == null){
            return false;
        }

        else if(!staff.getIsDeleted() && staff.getActive()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public UUID createCustomer(String fName, String lName, String email) {
        String password = UUID.randomUUID().toString();
        UUID newId = _customerRepository.createCustomer(
                new CustomerViewModel(null, "", password, fName, lName,
                        email, true, false, LocalDate.now(), null));

        if(newId != null){

            return newId;

        }
        return null;
    }

    @Override
    public UUID createAdmin(String fName, String lName, String email) {
        String password = UUID.randomUUID().toString();
        Portfolio portfolio = Portfolio.Manager;
        UUID newId = _staffRepository.createStaff(
                new StaffViewModel(null, fName, lName, password, "",
                        portfolio, email, true,
                        false, LocalDate.now(), null));

        if(newId != null){
            return newId;
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(String email) {
        try {

            _customerRepository.deleteCustomerByEmail(email);

            return true;

        } catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean deleteStaff(String email) {
        try {

            _staffRepository.deleteStaffByEmail(email);
            return true;

        } catch(Exception ex){
            return false;
        }
    }
}

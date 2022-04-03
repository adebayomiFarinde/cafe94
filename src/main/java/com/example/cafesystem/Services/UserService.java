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

/**
 *  This class is a service class that implements all the abstract methods in the IUserService class.
 */

public class UserService extends IUserService {
    private ICustomerRepository _customerRepository;
    private IStaffRepository _staffRepository;

    /**
     * Initialize the UserService.
     * @param customerRepository The customerRepository component, where all customers are stored.
     * @param staffRepository The staffRepository component, where all staff are stored.
     */
    public UserService(ICustomerRepository customerRepository,
                       IStaffRepository staffRepository) {
        _customerRepository = customerRepository;
        _staffRepository = staffRepository;
    }

    /**
     * Customer login verification.
     * @param email  The email component.
     * @param password The password  component.
     * @return Whether the login was successful.
     */
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

    /**
     * Admin login verification.
     * @param email  The email component.
     * @param password The password  component.
     * @return  Whether the login was successful.
     */
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

    /**
     * Create customer.
     * @param fName  The first name component.
     * @param lName The last name component.
     * @param email The email component.
     * @return The id of the created customer.
     */
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

    /**
     * Create admin.
     * @param fName  The first name component.
     * @param lName The last name component.
     * @param email The email component.
     * @return The id of the created admin.
     */
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

    /**
     * Delete customer from repository.
     * @param email  The email component.
     * @return Whether it was deleted correctly.
     */
    @Override
    public boolean deleteCustomer(String email) {
        try {

            _customerRepository.deleteCustomerByEmail(email);

            return true;

        } catch(Exception ex){
            return false;
        }
    }

    /**
     * Delete staff from repository.
     * @param email  The email component.
     * @return Whether it was deleted correctly.
     */
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

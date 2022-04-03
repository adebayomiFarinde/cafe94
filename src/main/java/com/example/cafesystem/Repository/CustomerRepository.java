package com.example.cafesystem.Repository;


import com.example.cafesystem.Customer;
import com.example.cafesystem.MockData;
import com.example.cafesystem.ViewModels.CustomerViewModel;
import com.example.cafesystem.ViewModels.UpdateCustomerViewModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *  This class is a repository class that implements all the abstract methods in the ICustomerRepository class.
 */
public class CustomerRepository extends ICustomerRepository{


    /** Create a new Customer, add it to the repository.
     * @param customer  The customer to be added.
     * @return id of the new Customer.
     */
    @Override
    public UUID createCustomer(CustomerViewModel customer) {
        ArrayList<Customer> all = MockData.getCustomers();
        UUID newId = UUID.randomUUID();

        try{
            all.add(new Customer(newId, customer.getfName(), customer.getlName(),
                    customer.getPassword(), customer.getAddress(),
                    customer.getEmail().toLowerCase(Locale.ROOT), true, false, LocalDate.now(), UUID.randomUUID()));

            MockData.setCustomers(all);

            return newId;

        }catch (Exception ex){
            return  null;
        }
    }


    /** Update a Customer.
     * @param customerId The customerID of the Booking to be updated.
     * @param customerViewModel The customer object.
     */
    @Override
    public void updateCustomer(UUID customerId, UpdateCustomerViewModel customerViewModel) {
        ArrayList<Customer> all = MockData.getCustomers();
        Customer customer =  getCustomerId(customerId);

        int index = all.indexOf(customer);
        customer.setAddress(customerViewModel.address);
        customer.setPassword(customerViewModel.password);
        customer.setfName(customerViewModel.fName);
        customer.setlName(customerViewModel.lName);

        all.set(index, customer);

        MockData.setCustomers(all);

        return;
    }


    /** Get list of all customers.
     * @return The list containing all customers.
     */
    @Override
    public List<Customer> getAllCustomers() {
        ArrayList<Customer> all = MockData.getCustomers();

        return all.stream().filter(x -> !x.getIsDeleted()).collect(Collectors.toList());
    }


    /** Delete a booking by passing his customer ID.
     * @param customerId Customer ID used to delete booking.
     */
    @Override
    public void deleteCustomer(UUID customerId) {
        ArrayList<Customer> all = MockData.getCustomers();
        all.removeIf(x -> x.getId().equals(customerId));

        MockData.setCustomers(all);

        return;
    }


    /** Get customer based on the customer's ID.
     * @param customerId The customer ID used to identify each customer.
     * @return Customer corresponding to the customerId.
     */
    @Override
    public Customer getCustomerId(UUID customerId) {
        ArrayList<Customer> all = MockData.getCustomers();

        return all.stream().filter(x -> x.getId().equals(customerId)).findAny().orElse(null);
    }


    /** Delete a booking by passing its email.
     * @param email Email used to delete a customer.
     */
    @Override
    public void deleteCustomerByEmail(String email) {
        ArrayList<Customer> all = MockData.getCustomers();

        Customer customer = all.stream().filter(x -> x.getEmail().equals(email)).findAny().orElse(null);

        if(customer != null){
            deleteCustomer(customer.getId());
        }

    }


    /** Get customer based on customers email and password.
     * @param email The email used to identify each customer.
     * @param password The password used to identify each customer.
     * @return Customer with the corresponding email and password.
     */
    @Override
    public Customer getCustomerByEmailPassword(String email, String password) {
        ArrayList<Customer> all = MockData.getCustomers();

        return all.stream().filter(x -> x.getEmail().equals(email) && x.getPassword().equals(password))
                .findAny().orElse(null);
    }
}

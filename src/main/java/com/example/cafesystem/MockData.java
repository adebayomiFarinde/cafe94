package com.example.cafesystem;

import com.example.cafesystem.ViewModels.Enum.Portfolio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MockData {
    private static ArrayList<Item> items;
    private static ArrayList<Staff> staff;
    private static ArrayList<Customer> customers;
    private static ArrayList<Booking> bookings;
    private static ArrayList<Order> orders;
    private static String fName;
    private static String lName;
    private static String email;
    private static UUID customerId;
    private static UUID staffId;

    public static UUID getCustomerId() {
        return customerId;
    }

    public static void setCustomerId(UUID customerId) {
        MockData.customerId = customerId;
    }

    public static ArrayList<UUID> allUUID(){
        ArrayList guidList = new ArrayList<UUID>();
        guidList.add(UUID.fromString("123e4567-e89b-42d3-a456-556642440000"));
        guidList.add(UUID.fromString("123e4967-e89b-42d3-a456-556642440000"));
        guidList.add(UUID.fromString("123e4567-e89b-82d3-a456-556642440000"));
        guidList.add(UUID.fromString("123e4567-e89b-42d3-a456-554442440000"));
        guidList.add(UUID.fromString("123e4567-e89b-42d3-a456-556642440670"));
        guidList.add(UUID.fromString("123e4567-e89b-42d3-a456-556642440670"));
        guidList.add(UUID.fromString("132e4567-e89b-42d3-a456-556642440670"));

        return guidList;
    }

    public static UUID getStaffId() {
        return staffId;
    }

    public static void setStaffId(UUID staffId) {
        MockData.staffId = staffId;
    }

    public static String getfName() {
        return MockData.fName;
    }

    public static void setfName(String fName) {
        MockData.fName = fName;
    }

    public static String getlName() {
        return MockData.lName;
    }

    public static void setlName(String lName) {
        MockData.lName = lName;
    }

    public static String getEmail() {
        return MockData.email;
    }

    public static void setEmail(String email) {
        MockData.email = email;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static void setItems(ArrayList<Item> items) {
        MockData.items = items;
    }

    public static void setStaff(ArrayList<Staff> staff) {
        MockData.staff = staff;
    }

    public static void setCustomers(ArrayList<Customer> customers) {
        MockData.customers = customers;
    }

    public static void setBookings(ArrayList<Booking> bookings) {
        MockData.bookings = bookings;
    }

    public static void setOrders(ArrayList<Order> orders) {
        MockData.orders = orders;
    }

    public static ArrayList<Staff> getStaff() {
        if(staff == null){

            staff = new ArrayList<>();
            staff.add(new Staff(allUUID().get(0), "Visi", "Lesi",
                    "password","Swansea Uni", Portfolio.Manager,
                    "2126141@swansea.ac.uk", true, false, LocalDate.now(), UUID.randomUUID()));
            staff.add(new Staff(allUUID().get(1), "Adebayomi", "Farinde",
                    "password","Swansea Uni", Portfolio.Chef, "2130957@swansea.ac.uk",
                    true, false, LocalDate.now(), UUID.randomUUID()));
            staff.add(new Staff(allUUID().get(2), "Others", "Students",
                    "password","Swansea Uni", Portfolio.Driver, "example@swansea.ac.uk",
                    false, false, LocalDate.now(), UUID.randomUUID()));
        }

        return staff;
    }

    public static ArrayList<Customer> getCustomers() {

        if(customers == null){
            customers = new ArrayList<>();

            customers.add(new Customer(allUUID().get(3), "Brad", "Pitt",
                    "password","United State",
                    "bradpitt@example.com", true, false, LocalDate.now(), UUID.randomUUID()));
            customers.add(new Customer(allUUID().get(4), "John", "Doe",
                    "password","United Kingdom", "johndoe@example.com",
                    true, false, LocalDate.now(), UUID.randomUUID()));
            customers.add(new Customer(allUUID().get(5), "Lakeside", "Smith",
                    "password","Swansea Uni", "lakeside@example.com",
                    false, false, LocalDate.now(), UUID.randomUUID()));
        }

        return customers;
    }

    public static ArrayList<Booking> getBookings() {
        if(bookings == null){
            bookings = new ArrayList<>();
            bookings.add(new Booking(UUID.randomUUID(), LocalDateTime.now(), allUUID().get(3),
                            12, false, true,LocalDate.now(), allUUID().get(3)));
            bookings.add(new Booking(UUID.randomUUID(), LocalDateTime.now().plusDays(20), allUUID().get(3),
                    12, false, true,LocalDate.now().plusYears(2), allUUID().get(3)));
            bookings.add(new Booking(UUID.randomUUID(), LocalDateTime.now().plusYears(1), allUUID().get(3),
                    12, false, true,LocalDate.now(), allUUID().get(3)));
            bookings.add(new Booking(UUID.randomUUID(), LocalDateTime.now().plusYears(1), allUUID().get(0),
                    12, false, true,LocalDate.now(), allUUID().get(3)));
            bookings.add(new Booking(UUID.randomUUID(), LocalDateTime.now().plusYears(1), allUUID().get(1),
                    12, false, true,LocalDate.now(), allUUID().get(3)));
        }

        return bookings;
    }

    public static ArrayList<Order> getOrders() {
        if(orders == null){
            orders = new ArrayList<>();
        }
        return orders;
    }
}

package com.example.cafesystem;

import com.example.cafesystem.ViewModels.Enum.Portfolio;

import java.util.ArrayList;
import java.util.UUID;

public class MockData {
    private static ArrayList<Item> items;
    private static ArrayList<Staff> staff;
    private static ArrayList<Customer> customers;
    private static ArrayList<Booking> bookings;
    private static ArrayList<Order> orders;

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
            staff.add(new Staff(UUID.randomUUID(), "Visi", "Lesi",
                    "password","Swansea Uni", Portfolio.Manager, "2126141@swansea.ac.uk"));
            staff.add(new Staff(UUID.randomUUID(), "Adebayomi", "Farinde",
                    "password","Swansea Uni", Portfolio.Chef, "2130957@swansea.ac.uk"));
            staff.add(new Staff(UUID.randomUUID(), "Others", "Students",
                    "password","Swansea Uni", Portfolio.Driver, "example@swansea.ac.uk"));
        }

        return staff;
    }

    public static ArrayList<Customer> getCustomers() {
        if(customers == null){
            customers = new ArrayList<>();
        }
        return customers;
    }

    public static ArrayList<Booking> getBookings() {
        if(bookings == null){
            bookings = new ArrayList<>();
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

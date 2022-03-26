package com.example.cafesystem;

import java.util.ArrayList;

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

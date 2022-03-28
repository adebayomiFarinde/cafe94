package com.example.cafesystem;

import com.example.cafesystem.ViewModels.CreateBooking;

import java.util.UUID;

public class Booking extends BaseEntity
{
    private String bookingDay;
    private int bookingTime;
    private UUID customerID;
    private int numberOfGuest;

    public Booking(UUID bookingId, String bookingDay, int bookingTime, UUID customerID, int numberOfGuest) {
        super(bookingId);
        this.bookingDay = bookingDay;
        this.bookingTime = bookingTime;
        this.customerID = customerID;
        this.numberOfGuest = numberOfGuest;
    }

    public String getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(String bookingDay) {
        this.bookingDay = bookingDay;
    }

    public int getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(int bookingTime) {
        this.bookingTime = bookingTime;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }

    public int getNumberOfGuest() {
        return numberOfGuest;
    }

    public void setNumberOfGuest(int numberOfGuest) {
        this.numberOfGuest = numberOfGuest;
    }
}

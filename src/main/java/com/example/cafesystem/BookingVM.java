package com.example.cafesystem;

import java.time.LocalDateTime;

public class BookingVM {
    private String isActive;
    private String bookingTime;
    private String numberOfGuest;

    public BookingVM(Boolean isActive, LocalDateTime bookingTime, Integer numberOfGuest){
        this.isActive = isActive.toString();
        this.bookingTime = bookingTime.toString();
        this.numberOfGuest = numberOfGuest.toString();

    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getNumberOfGuest() {
        return numberOfGuest;
    }

    public void setNumberOfGuest(String numberOfGuest) {
        this.numberOfGuest = numberOfGuest;
    }
}

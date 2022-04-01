package com.example.cafesystem;

import java.time.LocalDateTime;

public class BookingVM {
    private String name;
    private String isActive;
    private String bookingTime;
    private String numberOfGuest;
    private String referenceCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public BookingVM(String name, Boolean isActive, LocalDateTime bookingTime, Integer numberOfGuest, String referenceCode){
        this.isActive = isActive.toString();
        this.bookingTime = bookingTime.toString();
        this.numberOfGuest = numberOfGuest.toString();
        this.referenceCode = referenceCode;
        this.name = name;

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

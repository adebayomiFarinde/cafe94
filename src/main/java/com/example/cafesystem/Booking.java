package com.example.cafesystem;

import com.example.cafesystem.ViewModels.CreateBooking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Booking extends BaseEntity
{
    private LocalDateTime bookingTime;
    private UUID customerID;
    private int numberOfGuest;
    private String referenceCode;

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public Booking(UUID bookingId, String referenceCode, LocalDateTime bookingTime, UUID customerID, int numberOfGuest,
                   boolean isDeleted, boolean isActive, LocalDate createdDate, UUID createdBy) {
        super(bookingId, isDeleted, isActive, createdDate, createdBy);
        this.bookingTime = bookingTime;
        this.customerID = customerID;
        this.numberOfGuest = numberOfGuest;
        this.referenceCode = referenceCode;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
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

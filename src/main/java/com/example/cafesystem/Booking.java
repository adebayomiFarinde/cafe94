package com.example.cafesystem;

import com.example.cafesystem.ViewModels.CreateBooking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class represent a Booking made by a customer.
 */
public class Booking extends BaseEntity
{
    private LocalDateTime bookingTime;
    private UUID customerID;
    private int numberOfGuest;
    private String referenceCode;

    /**
     * Create a Booking with the following params:
     * @param bookingId The booking ID
     * @param referenceCode The reference Code
     * @param bookingTime The Booking Time
     * @param customerID The Customer ID
     * @param numberOfGuest The number of guests
     * @param isDeleted Whether it is deleted or not
     * @param isActive Whether it is active or not
     * @param createdDate The creation Date
     * @param createdBy Who created the Booking
     */
    public Booking(UUID bookingId, String referenceCode, LocalDateTime bookingTime, UUID customerID, int numberOfGuest,
                   boolean isDeleted, boolean isActive, LocalDate createdDate, UUID createdBy) {
        super(bookingId, isDeleted, isActive, createdDate, createdBy);
        this.bookingTime = bookingTime;
        this.customerID = customerID;
        this.numberOfGuest = numberOfGuest;
        this.referenceCode = referenceCode;
    }

    /**
     * Get the reference code component.
     * @return The reference Code.
     */
    public String getReferenceCode() {
        return referenceCode;
    }

    /**
     * Set the reference code component.
     * @param referenceCode The new reference code.
     */
    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }


    /** Get the Booking time component.
     * @return The Booking Time.
     */
    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    /**
     * Get the Booking time component.
     * @param bookingTime The new Booking Time.
     */
    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    /** Get the customer ID component.
     * @return The Customer ID.
     */
    public UUID getCustomerID() {
        return customerID;
    }

    /**
     * Set the Customer ID  component.
     * @param customerID The new Customer ID.
     */
    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }

    /** Get the number of guests component.
     * @return The number of guests.
     */
    public int getNumberOfGuest() {
        return numberOfGuest;
    }

    /**
     * Set number of guests  component.
     * @param numberOfGuest The number of guests.
     */
    public void setNumberOfGuest(int numberOfGuest) {
        this.numberOfGuest = numberOfGuest;
    }
}

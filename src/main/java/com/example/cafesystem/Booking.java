package com.example.cafesystem;

import com.example.cafesystem.ViewModels.CreateBooking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class represent a Booking made by a customer (bookingId,referenceCode,bookingTime,customerID,numberOfGuest
 * isDeleted,isActive,createdDate,createdBy)
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
     *
     * @return The reference Code
     */
    public String getReferenceCode() {
        return referenceCode;
    }

    /**
     * Set the reference code
     * @param referenceCode
     */
    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }


    /**
     * @return the Booking Time
     */
    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    /**
     * Set the booking Time
     * @param bookingTime
     */
    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    /**
     * @return The Customer ID
     */
    public UUID getCustomerID() {
        return customerID;
    }

    /**
     * Set the Customer ID
     * @param customerID
     */
    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }

    /**
     * @return The number of guests
     */
    public int getNumberOfGuest() {
        return numberOfGuest;
    }

    /**
     * The number of guests
     * @param numberOfGuest
     */
    public void setNumberOfGuest(int numberOfGuest) {
        this.numberOfGuest = numberOfGuest;
    }
}

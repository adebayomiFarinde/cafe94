package com.example.cafesystem;

import java.time.LocalDateTime;

/**
 * This class represents a view model for the Booking class (name,isActive,bookingTime,numberOfGuest,referenceCode).
 * This class exposes certain booking properties.
 */
public class BookingVM {
    private String name;
    private String isActive;
    private String bookingTime;
    private String numberOfGuest;
    private String referenceCode;

    /**
     * Get the name component.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name component.
     * @param name The name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the reference Code component.
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

    /**
     * Create an instance of the BookingVM with the following properties:
     * @param name The name component.
     * @param isActive Whether is active or not.
     * @param bookingTime The booking Time component.
     * @param numberOfGuest The number of guests component.
     * @param referenceCode The reference code component.
     */
    public BookingVM(String name, Boolean isActive, LocalDateTime bookingTime, Integer numberOfGuest, String referenceCode){
        this.isActive = isActive.toString();
        this.bookingTime = bookingTime.toString();
        this.numberOfGuest = numberOfGuest.toString();
        this.referenceCode = referenceCode;
        this.name = name;

    }

    /**
     * Get whether is active or not.
     * @return the isActive component.
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * Set the isActive component.
     * @param isActive The new isActive.
     */
    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    /**
     * Get the bookingTime component.
     * @return The bookingTime.
     */
    public String getBookingTime() {
        return bookingTime;
    }

    /**
     * Set the bookingTime component.
     * @param bookingTime The new booking time.
     */
    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    /**
     * Get the number of guests component.
     * @return The number of guests.
     */
    public String getNumberOfGuest() {
        return numberOfGuest;
    }

    /**
     * Set the number of guests component.
     * @param numberOfGuest The new number of guests.
     */
    public void setNumberOfGuest(String numberOfGuest) {
        this.numberOfGuest = numberOfGuest;
    }
}

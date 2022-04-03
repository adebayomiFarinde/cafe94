package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class represents a View Model for the Booking class, to assist in Creating and Updating Bookings..
 */

public class UpdateCreateBooking  extends Booking {

    /**
     * Create a Booking with the following params:
     * @param bookingId  The booking ID
     * @param referenceCode The reference Code
     * @param bookingTime The Booking Time
     * @param customerID The Customer ID
     * @param numberOfGuest The number of guests
     * @param isDeleted Whether it is deleted or not
     * @param isActive Whether it is active or not
     * @param createdDate The creation Date
     * @param createdBy Who created the Booking
     */
    public UpdateCreateBooking(UUID bookingId, String referenceCode, LocalDateTime bookingTime, UUID customerID, int numberOfGuest, boolean isDeleted, boolean isActive, LocalDate createdDate, UUID createdBy) {
        super(bookingId, referenceCode, bookingTime, customerID, numberOfGuest, isDeleted, isActive, createdDate, createdBy);
    }
}

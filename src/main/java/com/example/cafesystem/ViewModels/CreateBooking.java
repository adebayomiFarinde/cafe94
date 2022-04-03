package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class represents a View Model to create a Booking.
 */

public class CreateBooking extends Booking {

    /**
     * Crate Booking with the following attributes:
     * @param bookingId The booking id component.
     * @param referenceCode The referenceCode component.
     * @param bookingTime The bookingTime component.
     * @param customerID The customerID component.
     * @param numberOfGuest The numberOfGuest component.
     * @param isDeleted Whether it is deleted or not.
     * @param isActive Whether it is active or not.
     * @param createdDate The creation Date.
     * @param createdBy Who created the Person instance.
     */
    public CreateBooking(UUID bookingId, String referenceCode, LocalDateTime bookingTime, UUID customerID, int numberOfGuest, boolean isDeleted, boolean isActive, LocalDate createdDate, UUID createdBy) {
        super(bookingId, referenceCode, bookingTime, customerID, numberOfGuest, isDeleted, isActive, createdDate, createdBy);
    }
}

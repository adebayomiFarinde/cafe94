package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class UpdateCreateBooking  extends Booking {

    public UpdateCreateBooking(UUID bookingId, String referenceCode, LocalDateTime bookingTime, UUID customerID, int numberOfGuest, boolean isDeleted, boolean isActive, LocalDate createdDate, UUID createdBy) {
        super(bookingId, referenceCode, bookingTime, customerID, numberOfGuest, isDeleted, isActive, createdDate, createdBy);
    }
}

package com.example.cafesystem.Repository;
import com.example.cafesystem.*;
import com.example.cafesystem.ViewModels.CreateBooking;
import com.example.cafesystem.ViewModels.UpdateCreateBooking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookingRepository extends IBookingRepository{
    @Override
    public UUID createBooking(CreateBooking booking) {
        ArrayList<Booking> all = MockData.getBookings();
        UUID newId = UUID.randomUUID();
        all.add(new Booking(newId, booking.getBookingDay(), booking.getBookingTime(),
                booking.getCustomerID(), booking.getNumberOfGuest()));
        MockData.setBookings(all);

        return newId;
    }

    @Override
    public List<Booking> getAllBookingByCustomerId(UUID customerID) {
        ArrayList<Booking> all = MockData.getBookings();

        List<Booking> list = all.stream().filter(x -> x.getId() == customerID)
                .collect(Collectors.toList());

        list.sort(Comparator.comparing(Booking::getCreatedDate));

        return list;
    }

    @Override
    public void updateBooking(UUID bookingId, UpdateCreateBooking updateCreateBooking) {
        ArrayList<Booking> all = MockData.getBookings();
        Booking booking =  getBookingId(bookingId);

        int index = all.indexOf(booking);

        booking.setBookingDay(updateCreateBooking.bDay);
        booking.setNumberOfGuest(updateCreateBooking.noGuests);
        booking.setBookingTime(updateCreateBooking.dTime);

        all.set(index, booking);

        MockData.setBookings(all);

        return;
    }

    @Override
    public void deleteBooking(UUID bookingId) {
        ArrayList<Booking> all = MockData.getBookings();
        all.removeIf(x -> x.getId() == bookingId);

        MockData.setBookings(all);

        return;
    }

    @Override
    public Booking getBookingId(UUID bookingId) {
        ArrayList<Booking> all = MockData.getBookings();

        return all.stream().filter(x -> x.getId() == bookingId).findAny().orElse(null);
    }
}

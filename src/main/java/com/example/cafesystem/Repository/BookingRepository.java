package com.example.cafesystem.Repository;
import com.example.cafesystem.*;
import com.example.cafesystem.ViewModels.CreateBooking;
import com.example.cafesystem.ViewModels.UpdateCreateBooking;

import java.time.LocalDate;
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

        UUID createdBy =  MockData.getCustomerId().equals(UUID.fromString("00000000-0000-0000-0000-000000000000")) ?
                MockData.getStaffId(): MockData.getCustomerId();

        all.add(new Booking(newId, booking.getReferenceCode(), booking.getBookingTime(),
                booking.getCustomerID(), booking.getNumberOfGuest(), false,
                booking.getActive(), LocalDate.now(), createdBy));
        MockData.setBookings(all);

        return newId;
    }

    @Override
    public List<Booking> getAllBookings() {
        ArrayList<Booking> all = MockData.getBookings();

        return all.stream().filter(x -> !x.getIsDeleted()).collect(Collectors.toList());
    }

    @Override
    public List<Booking> getAllBookingByCustomerId(UUID customerID) {
        ArrayList<Booking> all = MockData.getBookings();

        List<Booking> list = all.stream().filter(x -> x.getCustomerID().equals(customerID))
                .collect(Collectors.toList());

        list.sort(Comparator.comparing(Booking::getCreatedDate));

        return list;
    }

    @Override
    public void updateBooking(UUID bookingId, UpdateCreateBooking updateCreateBooking) {
        ArrayList<Booking> all = MockData.getBookings();
        Booking booking =  getBookingId(bookingId);

        int index = all.indexOf(booking);

        booking.setBookingTime(updateCreateBooking.getBookingTime());
        booking.setNumberOfGuest(updateCreateBooking.getNumberOfGuest());
        booking.setModifiedBy(updateCreateBooking.getCreatedBy());

        all.set(index, booking);

        MockData.setBookings(all);

        return;
    }

    @Override
    public void deleteBooking(UUID bookingId) {
        ArrayList<Booking> all = MockData.getBookings();
        all.removeIf(x -> x.getId().equals(bookingId));

        MockData.setBookings(all);

        return;
    }

    @Override
    public Booking getBookingId(UUID bookingId) {
        ArrayList<Booking> all = MockData.getBookings();

        return all.stream().filter(x -> x.getId().equals(bookingId)).findAny().orElse(null);
    }
}

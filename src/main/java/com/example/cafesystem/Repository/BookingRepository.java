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

/**
 *  This class is a repository class that implements all the abstract methods in the IBookingRepository class.
 */
public class BookingRepository extends IBookingRepository{

    /** Create a new booking, add it to the repository.
     * @param booking The booking to be added.
     * @return id of the new Booking.
     */
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

    /** Get list of all bookings.
     * @return The list containing all bookings.
     */
    @Override
    public List<Booking> getAllBookings() {
        ArrayList<Booking> all = MockData.getBookings();

        return all.stream().filter(x -> !x.getIsDeleted()).collect(Collectors.toList());
    }

    /** Delete a booking by passing its reference code.
     * @param referenceCode Code used to delete booking.
     */
    @Override
    public void deleteBookingByReferenceCode(String referenceCode) {
        ArrayList<Booking> all = MockData.getBookings();
        all.removeIf(x -> x.getReferenceCode().equals(referenceCode));

        MockData.setBookings(all);
    }

    /** Get all bookings based on the customers ID.
     * @param customerID The customer ID used to identify each customer.
     * @return The list of all Bookings.
     */
    @Override
    public List<Booking> getAllBookingByCustomerId(UUID customerID) {
        ArrayList<Booking> all = MockData.getBookings();

        List<Booking> list = all.stream().filter(x -> x.getCustomerID().equals(customerID))
                .collect(Collectors.toList());

        list.sort(Comparator.comparing(Booking::getCreatedDate));

        return list;
    }

    /** Update a Booking.
     * @param bookingId The bookingID of the Booking to be updated.
     * @param updateCreateBooking The booking object.
     */
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

    /** Delete a Booking.
     * @param bookingId Booking Id used to delete corresponding Booking.
     */
    @Override
    public void deleteBooking(UUID bookingId) {
        ArrayList<Booking> all = MockData.getBookings();
        all.removeIf(x -> x.getId().equals(bookingId));

        MockData.setBookings(all);
    }

    /** Get a Booking based on Id component.
     * @param bookingId The booking Id component.
     * @return The bookings corresponding to bookingID param passed.
     */
    @Override
    public Booking getBookingId(UUID bookingId) {
        ArrayList<Booking> all = MockData.getBookings();

        return all.stream().filter(x -> x.getId().equals(bookingId)).findAny().orElse(null);
    }
}

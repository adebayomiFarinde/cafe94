package com.example.cafesystem;

import com.example.cafesystem.ViewModels.Enum.Portfolio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This class acts as a database of the application.
 */
public class MockData {
    private static ArrayList<Menu> menu;
    private static ArrayList<Staff> staff;
    private static ArrayList<Customer> customers;
    private static ArrayList<Booking> bookings;
    private static ArrayList<Order> orders;
    private static ArrayList<Takeaway> takeaways;
    private static String fName;
    private static String lName;
    private static String email;
    private static UUID customerId;
    private static UUID staffId;

    /**
     * Get the customer ID component.
     * @return The customer ID.
     */
    public static UUID getCustomerId() {
        return customerId;
    }

    /**
     * Set the customer ID component.
     * @param customerId The new customer id.
     */
    public static void setCustomerId(UUID customerId) {
        MockData.customerId = customerId;
    }

    /**
     * List of all the ID's.
     * @return the list of all ID's.
     */
    public static ArrayList<UUID> allUUID(){

        ArrayList guidList = new ArrayList<UUID>();
        guidList.add(UUID.fromString("123e4567-e89b-42d3-a456-556642440000"));
        guidList.add(UUID.fromString("123e4967-e89b-42d3-a456-556642440000"));
        guidList.add(UUID.fromString("123e4567-e89b-82d3-a456-556642440000"));
        guidList.add(UUID.fromString("123e4567-e89b-42d3-a456-554442440000"));
        guidList.add(UUID.fromString("123e4567-e89b-42d3-a456-556642440670"));
        guidList.add(UUID.fromString("123e4567-e89b-42d3-a456-556642440670"));
        guidList.add(UUID.fromString("132e4567-e89b-42d3-a456-556642440670"));
        guidList.add(UUID.fromString("123e3467-e89b-42d3-a456-554442440000"));
        guidList.add(UUID.fromString("123e4542-e89b-42d3-a456-556642440670"));
        guidList.add(UUID.fromString("123f4567-e89b-42d3-a456-556642440670"));
        guidList.add(UUID.fromString("132e4567-e89b-85d3-a456-556642440670"));

        return guidList;
    }

    /**
     *Get whether staff id component.
     * @return The staff id.
     */
    public static UUID getStaffId() {
        return staffId;
    }

    /**
     * Set the staff id component.
     * @param staffId The new staff id.
     */
    public static void setStaffId(UUID staffId) {
        MockData.staffId = staffId;
    }

    /**
     *Get the first name component.
     * @return The first name.
     */
    public static String getfName() {
        return MockData.fName;
    }

    /**
     * Set first name component .
     * @param fName The new first name.
     */
    public static void setfName(String fName) {
        MockData.fName = fName;
    }

    /**
     * Get the last name component.
     * @return The last name.
     */
    public static String getlName() {
        return MockData.lName;
    }

    /**
     * Set the last name component.
     * @param lName The new last name.
     */
    public static void setlName(String lName) {
        MockData.lName = lName;
    }

    /**
     * Get the email component.
     * @return The email address.
     */
    public static String getEmail() {
        return MockData.email;
    }

    /**
     * Set the email component.
     * @param email The new email.
     */
    public static void setEmail(String email) {
        MockData.email = email;
    }

    /**
     * Set the Menu component.
     * @param menu The new Menu.
     */
    public static void setMenu(ArrayList<Menu> menu) {
        MockData.menu = menu;
    }

    /**
     * Set the staff component.
     * @param staff The new staff.
     */
    public static void setStaff(ArrayList<Staff> staff) {
        MockData.staff = staff;
    }

    /**
     * Set the Customers component.
     * @param customers The new customers.
     */
    public static void setCustomers(ArrayList<Customer> customers) {
        MockData.customers = customers;
    }

    /**
     * Set the bookings component.
     * @param bookings The new bookings.
     */
    public static void setBookings(ArrayList<Booking> bookings) {
        MockData.bookings = bookings;
    }

    /**
     * Set the orders component.
     * @param orders The new orders.
     */
    public static void setOrders(ArrayList<Order> orders) {
        MockData.orders = orders;
    }

    /**
     * Set the takeaway component.
     * @param takeaways The new takeaway.
     */
    public static void setTakeaways(ArrayList<Takeaway> takeaways) {
        MockData.takeaways = takeaways;
    }

    /**
     * Get the List with all current Menus.
     * @return List of current Menus.
     */
    public static ArrayList<Menu> getMenu() {

        if(menu == null){
            menu = new ArrayList<>();

            menu.add(new Menu(allUUID().get(3), "Hot Pie", "With Water",
                    true, false, LocalDate.now(), UUID.randomUUID()));
            menu.add(new Menu(allUUID().get(4), "Shawarma", "With Juice",
                    true, false, LocalDate.now(), UUID.randomUUID()));
            menu.add(new Menu(allUUID().get(5),  "Hot Dog", "With Biggie Coke",
                    true, false, LocalDate.now(), UUID.randomUUID()));
            menu.add(new Menu(allUUID().get(6), "Peperoni", "With Fanta",
                    true, false, LocalDate.now(), UUID.randomUUID()));
            menu.add(new Menu(allUUID().get(7), "Small Bugger", "With Creamie Juice",
                    true, false, LocalDate.now(), UUID.randomUUID()));
            menu.add(new Menu(allUUID().get(8),  "Big Mac", "With Coke",
                    true, false, LocalDate.now(), UUID.randomUUID()));
        }

        return menu;
    }

    /**
     * Get the List with all current Takeaways.
     * @return List with all current Takeaways.
     */
    public static ArrayList<Takeaway> getTakeaways() {

        if(takeaways == null){
            takeaways = new ArrayList<>();

            takeaways.add(new Takeaway(allUUID().get(0),  allUUID().get(5), "TW1237",true,
                    false, LocalDate.now(), allUUID().get(6)));
            takeaways.add(new Takeaway(allUUID().get(1), allUUID().get(3),"TW1547", true,
                    false, LocalDate.now(), allUUID().get(4)));
            takeaways.add(new Takeaway(allUUID().get(2), allUUID().get(6),"TW4671", true,
                    false, LocalDate.now(), allUUID().get(3)));
        }

        return takeaways;
    }

    /**
     * Get the List with all current staff members.
     * @return List with all current staff members.
     */
    public static ArrayList<Staff> getStaff() {
        if(staff == null){

            staff = new ArrayList<>();
            staff.add(new Staff(allUUID().get(0), "Visi", "Lesi",
                    "password","Swansea Uni", Portfolio.Manager,
                    "2126141@swansea.ac.uk", true, false, LocalDate.now(), UUID.randomUUID()));
            staff.add(new Staff(allUUID().get(1), "Adebayomi", "Farinde",
                    "password","Swansea Uni", Portfolio.Chef, "2130957@swansea.ac.uk",
                    true, false, LocalDate.now(), UUID.randomUUID()));
            staff.add(new Staff(allUUID().get(2), "Others", "Students",
                    "password","Swansea Uni", Portfolio.Driver, "example@swansea.ac.uk",
                    false, false, LocalDate.now(), UUID.randomUUID()));
        }

        return staff;
    }

    /**
     *  Get the List with all current customers.
     * @return List with all current customers.
     */
    public static ArrayList<Customer> getCustomers() {

        if(customers == null){
            customers = new ArrayList<>();

            customers.add(new Customer(allUUID().get(3), "Brad", "Pitt",
                    "password","United State",
                    "bradpitt@example.com", true, false, LocalDate.now(), UUID.randomUUID()));
            customers.add(new Customer(allUUID().get(4), "John", "Doe",
                    "password","United Kingdom", "johndoe@example.com",
                    true, false, LocalDate.now(), UUID.randomUUID()));
            customers.add(new Customer(allUUID().get(5), "Lakeside", "Smith",
                    "password","Swansea Uni", "lakeside@example.com",
                    false, false, LocalDate.now(), UUID.randomUUID()));
        }

        return customers;
    }

    /**
     * Get the List with all current bookings.
     * @return List with all current bookings.
     */
    public static ArrayList<Booking> getBookings() {

        if(bookings == null){
            bookings = new ArrayList<>();
            bookings.add(new Booking(UUID.randomUUID(), "TEST-23-12-4", LocalDateTime.now(), allUUID().get(3),
                            12, false, true,LocalDate.now(), allUUID().get(3)));
            bookings.add(new Booking(UUID.randomUUID(), "TEST-23-9-4", LocalDateTime.now().plusDays(20), allUUID().get(3),
                    12, false, true,LocalDate.now().plusYears(2), allUUID().get(3)));
            bookings.add(new Booking(UUID.randomUUID(), "TEST-10-12-4", LocalDateTime.now().plusYears(1), allUUID().get(3),
                    12, false, true,LocalDate.now(), allUUID().get(3)));
            bookings.add(new Booking(UUID.randomUUID(), "TEST-51-12-4", LocalDateTime.now().plusYears(1), allUUID().get(0),
                    12, false, true,LocalDate.now(), allUUID().get(3)));
            bookings.add(new Booking(UUID.randomUUID(), "TEST-37-10-1", LocalDateTime.now().plusYears(1), allUUID().get(1),
                    12, false, true,LocalDate.now(), allUUID().get(3)));
        }

        return bookings;
    }

    /**
     * Get the List with all current orders.
     * @return List with all current orders.
     */
    public static ArrayList<Order> getOrders() {

        if(orders == null){
            orders = new ArrayList<>();
        }

        return orders;
    }
}

package com.example.cafesystem;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represent a Person.  (id,fName,lName,password,  address, email,
 *                    isActive,  isDeleted,  createdDate, createdBy )
 * Customers and Staff members will inherit from this class.
 */
public class Person extends BaseEntity {

    private String fName;
    private String lName;
    private String password;
    private String address;
    private String email;

    /**
     * Create a Person with the following attributes:
     * @param id The id component.
     * @param fName The first name component.
     * @param lName The last name component.
     * @param password The password component.
     * @param address The address component.
     * @param email The email component.
     * @param isActive Whether it is active or not.
     * @param isDeleted Whether it is deleted or not.
     * @param createdDate The creation Date.
     * @param createdBy Who created the Person instance.
     */
     public Person(UUID id, String fName, String lName,
                   String password, String address, String email,
                   boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy ) {
         super(id, isDeleted, isActive, createdDate, createdBy);
         setfName(fName);
         setlName(lName);
         setPassword(password);
         setAddress(address);
         setEmail(email);
     }

    /**
     * Get the last name component.
     * @return The last name.
     */
    public String getlName() {
        return lName;
    }

    /**
     * Get the email component.
     * @return The email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email component.
     * @param email New email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set the last name component.
     * @param lName New last name.
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * Get the address component.
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address component.
     * @param address The new address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the first name component.
     * @return The first name.
     */
    public String getfName() {
        return fName;
    }

    /**
     * Get the password component.
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password component.
     * @param password The new Password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *  Set the first name component.
     * @param fName The new first name.
     */
    public void setfName(String fName) {
        this.fName = fName;
    }
}

package com.example.cafesystem;

/**
 * This class represents a view model for the Staff class.
 */

public class StaffVM {
    private String firstName;
    private String lastName;
    private String email;
    private String isActive;
    private String isDeleted;

    /**
     * Get the first name component.
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name component.
     * @param firstName The new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name component.
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name component.
     * @param lastName New last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * Get whether is it active or not
     * @return The isActive component.
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     *  Set whether is it active or not.
     * @param isActive The new isActive.
     */
    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    /**
     * Get whether it is deleted or not.
     * @return The isDeleted component.
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * Set whether it is deleted or not.
     * @param isDeleted The new isDeleted component.
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * Get the creation Date component.
     * @return Creation Date.
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Set the creation Date component.
     * @param createdDate The new creation Date.
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    private String createdDate;

    /**
     *  Create a StaffVM with the following attributes:
     * @param fName The first name component.
     * @param lName The last name component.
     * @param email The email component.
     * @param isActive Whether it is active or not.
     * @param isDeleted  Whether it is deleted or not.
     * @param createdDate The creation Date.
     */
    public StaffVM(String fName, String lName, String email,
                   String isActive, String isDeleted, String createdDate){
        this.firstName = fName;
        this.lastName = lName;
        this.email = email;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.createdDate = createdDate;
    }
}

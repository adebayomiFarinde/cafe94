package com.example.cafesystem;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This class contains properties which are shared by all other classes(id,isDeleted,createdDate
 * ,isActive,createdBy,modifiedDate,modifiedBy)
 */

public class BaseEntity {
    private UUID id;
    private boolean isDeleted;
    private LocalDate createdDate;
    private boolean isActive;
    private UUID createdBy;
    private LocalDate modifiedDate;
    private UUID modifiedBy;

    /**
     * @return whether it is active or not
     */
    public boolean getActive() {
        return isActive;
    }

    /**
     * Set the activity level
     * @param active
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Create a BaseEntity with the following properties:
     * @param id The id
     * @param isDeleted  Whether it is deleted or not
     * @param isActive Whether it is active or not
     * @param createdDate The creation Date
     * @param createdBy Who created the Booking
     */
    public BaseEntity(UUID id, boolean isDeleted,
                      boolean isActive, LocalDate createdDate, UUID createdBy){

        this.id = id;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }

    /**
     * @return The id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Set the id
     * @param id
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return whether it is deleted or not
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * Set whether it is deleted or not
     * @param deleted
     */
    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    /**
     * @return the created Date
     */
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    /**
     * Set the created Date
     * @param createdDate
     */
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the creator
     */
    public UUID getCreatedBy() {
        return createdBy;
    }

    /**
     * Set who was the creator
     * @param createdBy
     */
    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the modified Date
     */
    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Set the modified Date
     * @param modifiedDate
     */
    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * @return who did the modifying
     */
    public UUID getModifiedBy() {
        return modifiedBy;
    }

    /**
     * Set who did the modifying
     * @param modifiedBy
     */
    public void setModifiedBy(UUID modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}

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

    /** Get whether it is active or not component.
     * @return The isActive status.
     */
    public boolean getActive() {
        return isActive;
    }

    /**
     * Set the activity level.
     * @param active The new activity Level.
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Create a BaseEntity with the following properties:
     * @param id The id.
     * @param isDeleted  Whether it is deleted or not.
     * @param isActive Whether it is active or not.
     * @param createdDate The creation Date.
     * @param createdBy Who created the instance.
     */
    public BaseEntity(UUID id, boolean isDeleted,
                      boolean isActive, LocalDate createdDate, UUID createdBy){

        this.id = id;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }

    /** Get the id component.
     * @return The id.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Set the id component.
     * @param id The new Id.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /** Get whether it is deleted or not component.
     * @return The isDeleted status.
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * Set whether it is deleted or not.
     * @param deleted The new isDeleted status.
     */
    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    /** Get the Creation Date component.
     * @return The created Date.
     */
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    /**
     * Set the Creation Date component.
     * @param createdDate The new creation Date.
     */
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    /** Get the creator component.
     * @return The creator.
     */
    public UUID getCreatedBy() {
        return createdBy;
    }

    /**
     * Set who was the creator component.
     * @param createdBy The entity who created this instance.
     */
    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    /** Get the modified date component.
     * @return The modified Date.
     */
    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Set the modified Date component.
     * @param modifiedDate The new modified Date.
     */
    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /** Get who modified the contents.
     * @return Modified by who.
     */
    public UUID getModifiedBy() {
        return modifiedBy;
    }

    /**
     * Set who did the modifying.
     * @param modifiedBy The new modifiedBy.
     */
    public void setModifiedBy(UUID modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}

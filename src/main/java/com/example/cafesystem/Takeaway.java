package com.example.cafesystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

/**
 * This class represents a Takeaway Order made by the customer (id, menuId, referenceCode, isActive,  isDeleted, createdDate,createdBy)
 */
public class Takeaway extends BaseEntity  {

    private LocalDateTime pickupTime;
    private UUID menuId;
    private String referenceCode;

    /**
     * Create a Takeaway Order with the following attributes:
     * @param id The id component.
     * @param menuId The menuId component.
     * @param referenceCode The reference code component.
     * @param isActive Whether it is active or not.
     * @param isDeleted Whether it is deleted or not.
     * @param createdDate The creation Date.
     * @param createdBy Who created the Takeaway Order.
     */
    public Takeaway(UUID id, UUID menuId, String referenceCode, boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy){
        super(id,isDeleted,  isActive, createdDate, createdBy);
        this.referenceCode = referenceCode;
        this.menuId = menuId;
    }

    /**
     * Get the Menu Id component.
     * @return The Menu ID.
     */
    public UUID getMenuId() {
        return menuId;
    }

    /**
     * Set the Menu Id component.
     * @param menuId The new Menu Id.
     */
    public void setMenuId(UUID menuId) {
        this.menuId = menuId;
    }

    /**
     * Get the reference code component.
     * @return The new reference code.
     */
    public String getReferenceCode() {
        return referenceCode;
    }

    /**
     * Set the reference code component.
     * @param referenceCode The new reference code.
     */
    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }
}


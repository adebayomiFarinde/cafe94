package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Takeaway;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a View Model for the Takeaway class.
 */

public class TakewayViewModel extends Takeaway {

    /**
     * Create a Takeaway Order with the following attributes:
     * @param id  The id component.
     * @param menuId The menuId component.
     * @param referenceCode The reference code component.
     * @param isActive Whether it is active or not.
     * @param isDeleted Whether it is deleted or not.
     * @param createdDate The creation Date.
     * @param createdBy Who created the Takeaway Order.
     */
    public TakewayViewModel(UUID id, UUID menuId, String referenceCode, boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy) {
        super(id, menuId, referenceCode, isActive, isDeleted, createdDate, createdBy);
    }
}

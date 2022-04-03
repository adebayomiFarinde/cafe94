package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class represents a View Model for the Order class.
 */

public class OrderViewModel extends Order {

    /**
     * Create a Order with the following attributes:
     * @param itemId  The item Id component.
     * @param menuId The menu Id component.
     * @param customerId The customer Id component.
     * @param orderTime The order time component.
     * @param isApproved Whether is has been approved or not.
     * @param completed Whether it has been completed or not.
     * @param isActive Whether it is deleted or not.
     * @param isDeleted Whether is active or not.
     * @param createdDate The creation Date.
     * @param createdBy Who created the Order.
     */
    public OrderViewModel(UUID itemId, UUID menuId, UUID customerId, LocalDate orderTime, boolean isApproved, boolean completed, boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy){
        super(itemId, menuId, customerId, orderTime, isApproved, completed, isDeleted,  isActive, createdDate, createdBy);
    }
}

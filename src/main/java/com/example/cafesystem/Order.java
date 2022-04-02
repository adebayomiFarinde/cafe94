package com.example.cafesystem;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents an Order made by customers/waiters. (orderId, menuId,
 *                  customerId, orderTime,isApproved,
 *                   completed, isDeleted, isActive, createdDate, createdBy)
 */
public class Order extends BaseEntity {
    private UUID orderId;
    private UUID menuId;
    private UUID customerId;
    private LocalDate orderTime;
    private boolean isApproved;
    private boolean completed;

    /**
     * Get the Menu Id component.
     * @return The Menu Id.
     */
    public UUID getMenuId() {
        return menuId;
    }

    /**
     * Set he Menu Id component.
     * @param menuId The new Menu In.
     */
    public void setMenuId(UUID menuId) {
        this.menuId = menuId;
    }

    /**
     * Create an Order with the following properties:
     * @param orderId The order Id component.
     * @param menuId The menu Id component.
     * @param customerId The customer Id component.
     * @param orderTime The order time component.
     * @param isApproved Whether is has been approved or not.
     * @param completed Whether it has been completed or not.
     * @param isDeleted Whether it is deleted or not.
     * @param isActive Whether is active or not.
     * @param createdDate The creation Date.
     * @param createdBy Who created the Order.
     */
    public Order(UUID orderId, UUID menuId,
                 UUID customerId, LocalDate orderTime, boolean isApproved,
                 boolean completed, boolean isDeleted, boolean isActive, LocalDate createdDate, UUID createdBy) {
        super(orderId, isDeleted, isActive, createdDate, createdBy);
        this.completed = completed;
        this.customerId = customerId;
        this.orderTime = orderTime;
        this.isApproved = isApproved;
    }

    /**
     * Get customer ID component.
     * @return The customer ID.
     */
    public UUID getCustomerId() {
        return customerId;
    }

    /**
     * Set the customer Id component.
     * @param customerId The new customer ID.
     */
    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    /**
     * Get orderTime component.
     * @return The orderTime component.
     */
    public LocalDate getOrderTime() {
        return orderTime;
    }

    /**
     * Set the orderTime component.
     * @param orderTime The new orderTime.
     */
    public void setOrderTime(LocalDate orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * Get whether it has been approved or not.
     * @return The isApproved component.
     */
    public boolean getApproved() {
        return isApproved;
    }

    /**
     * Set the isApproved component.
     * @param approved The new isApproved.
     */
    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    /**
     * Get whether order has been completed or not.
     * @return The completion status of the order.
     */
    public boolean getCompleted() {
        return completed;
    }

    /**
     * Set  whether order has been completed or not.
     * @param completed The new status of the order completion.
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

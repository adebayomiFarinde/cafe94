package com.example.cafesystem;

import java.time.LocalDate;
import java.util.UUID;

public class Order extends BaseEntity {
    private UUID orderId;
    private UUID menuId;
    private UUID customerId;
    private LocalDate orderTime;
    private boolean isApproved;
    private boolean completed;

    public UUID getMenuId() {
        return menuId;
    }

    public void setMenuId(UUID menuId) {
        this.menuId = menuId;
    }

    public Order(UUID orderId, UUID menuId,
                 UUID customerId, LocalDate orderTime, boolean isApproved,
                 boolean completed, boolean isDeleted, boolean isActive, LocalDate createdDate, UUID createdBy) {
        super(orderId, isDeleted, isActive, createdDate, createdBy);
        this.completed = completed;
        this.customerId = customerId;
        this.orderTime = orderTime;
        this.isApproved = isApproved;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDate orderTime) {
        this.orderTime = orderTime;
    }

    public boolean getApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

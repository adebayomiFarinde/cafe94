package com.example.cafesystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Delivery extends BaseEntity {
    private UUID orderId;
    private LocalTime deliveryTime;
    private String address;

    public Delivery(UUID deliveryId, UUID orderId, LocalTime deliveryTime, String address, boolean isDeleted, boolean isActive, LocalDate createdDate, UUID createdBy) {
        super(deliveryId, isDeleted, isActive, createdDate, createdBy);
        this.orderId = orderId;
        this.deliveryTime = deliveryTime;
        this.address = address;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

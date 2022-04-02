package com.example.cafesystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

/**
 * This class represents a Delivery (deliveryId,orderId,deliveryTime,address,isDeleted,isActive,createdDate,createdBy)
 */
public class Delivery extends BaseEntity {
    private UUID orderId;
    private LocalTime deliveryTime;
    private String address;

    /**
     * Create  Delivery with the following properties:
     * @param deliveryId The delivery Id.
     * @param orderId The order ID.
     * @param deliveryTime The delivery time.
     * @param address The address.
     * @param isDeleted  Whether it is deleted or not.
     * @param isActive Whether it is active or not.
     * @param createdDate The creation Date.
     * @param createdBy Who created the Booking.
     */
    public Delivery(UUID deliveryId, UUID orderId, LocalTime deliveryTime, String address, boolean isDeleted, boolean isActive, LocalDate createdDate, UUID createdBy) {
        super(deliveryId, isDeleted, isActive, createdDate, createdBy);
        this.orderId = orderId;
        this.deliveryTime = deliveryTime;
        this.address = address;
    }

    /**
     * Get the orderId component.
     * @return The order ID.
     */
    public UUID getOrderId() {
        return orderId;
    }

    /**
     * Set the orderId component.
     * @param orderId The new orderId.
     */
    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    /**
     * Get the deliveryTime component.
     * @return Teh delivery Time.
     */
    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * Set the deliveryTime component.
     * @param deliveryTime The new delivery Time.
     */
    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
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
}

package com.example.cafesystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Takeaway extends BaseEntity  {

    private LocalTime pickupTime;
    private UUID itemId;
    public Takeaway(UUID id, UUID itemId, boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy){
        super(id,isDeleted,  isActive, createdDate, createdBy);
    }

    public LocalTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }
}


package com.example.cafesystem;

import java.util.UUID;

public class Item extends BaseEntity {
    private UUID staffId;
    private String itemName;
    private String description;

    public Item(UUID id, UUID staffId, String itemName, String description){
        super(id);
        this.staffId = staffId;
        this.itemName = itemName;
        this.description = description;
    }

    public UUID getStaffId() {
        return staffId;
    }

    public void setStaffId(UUID staffId) {
        this.staffId = staffId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

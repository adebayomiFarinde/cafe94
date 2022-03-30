package com.example.cafesystem;

import com.example.cafesystem.ViewModels.Enum.ItemType;

import java.time.LocalDate;
import java.util.UUID;

public class Item extends BaseEntity {
    private UUID staffId;
    private String itemName;
    private String description;
    private ItemType itemType;

    public Item(UUID id, UUID staffId, String itemName, String description, ItemType  itemType,
                boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy){
        super(id,isDeleted,  isActive, createdDate, createdBy);
        this.staffId = staffId;
        this.itemName = itemName;
        this.description = description;
        this.itemType = itemType;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
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

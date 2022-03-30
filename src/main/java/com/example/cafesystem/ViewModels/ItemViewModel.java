package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Item;
import com.example.cafesystem.ViewModels.Enum.ItemType;

import java.time.LocalDate;
import java.util.UUID;

public class ItemViewModel extends Item {
    public ItemViewModel(UUID id, UUID staffId, String itemName, String description, ItemType itemType, boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy){
        super(id, staffId, itemName, description, itemType, isDeleted,  isActive, createdDate, createdBy);
    }
}

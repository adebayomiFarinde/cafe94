package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Item;
import com.example.cafesystem.ViewModels.Enum.ItemType;

import java.util.UUID;

public class ItemViewModel extends Item {
    public ItemViewModel(UUID id, UUID staffId, String itemName, String description, ItemType itemType){
        super(id, staffId, itemName, description, itemType);
    }
}

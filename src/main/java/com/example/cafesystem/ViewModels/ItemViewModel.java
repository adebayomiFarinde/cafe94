package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Item;

import java.util.UUID;

public class ItemViewModel extends Item {
    public ItemViewModel(UUID staffId, String itemName, String description){
        super(staffId, itemName, description);
    }
}

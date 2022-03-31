package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Menu;

import java.time.LocalDate;
import java.util.UUID;

public class MenuViewModel extends Menu {
    public MenuViewModel(UUID id, String name, String description, boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy){
        super(id, name, description, isDeleted,  isActive, createdDate, createdBy);
    }
}

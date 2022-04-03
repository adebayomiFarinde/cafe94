package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Menu;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a View Model for the Customer class.
 */

public class MenuViewModel extends Menu {

    /**
     * Create a Menu with the following attributes:
     * @param id The id component.
     * @param name The name component.
     * @param description A description of the menu.
     * @param isActive Whether is active or not.
     * @param isDeleted Whether it is deleted or not.
     * @param createdDate The creation Date.
     * @param createdBy Who created the Menu.
     */
    public MenuViewModel(UUID id, String name, String description, boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy){
        super(id, name, description, isDeleted,  isActive, createdDate, createdBy);
    }
}

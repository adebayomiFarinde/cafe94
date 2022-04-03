package com.example.cafesystem;
//Customers can make food and drink orders from a limited menu
// waiters and customers will both need a method to order food


import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a Menu.
 */
public class Menu extends BaseEntity {
    private String name;
    private String description;

    /**
     * Create a Menu with the following properties:
     * @param id The id component.
     * @param name The name component.
     * @param description A description of the menu.
     * @param isActive Whether is active or not.
     * @param isDeleted Whether it is deleted or not.
     * @param createdDate The creation Date.
     * @param createdBy Who created the Menu.
     */
    public Menu(UUID id, String name, String description,
                boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy){
        super(id,isDeleted,  isActive, createdDate, createdBy);
        this.name = name;
        this.description = description;
    }

    /**
     * Get the name component.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name component.
     * @param name The new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *Get the description component.
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     *Set the description component.
     * @param description The new description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}

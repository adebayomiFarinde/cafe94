package com.example.cafesystem;
//Customers can make food and drink orders from a limited menu
// waiters and customers will both need a method to order food


import java.time.LocalDate;
import java.util.UUID;

public class Menu extends BaseEntity {
    private String name;
    private String description;

    public Menu(UUID id, String name, String description,
                boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy){
        super(id,isDeleted,  isActive, createdDate, createdBy);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

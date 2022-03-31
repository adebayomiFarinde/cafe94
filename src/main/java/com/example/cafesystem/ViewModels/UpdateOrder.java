package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class UpdateOrder extends Order {
    public UpdateOrder(UUID itemId, UUID menuId, UUID customerId, LocalDate orderTime, boolean isApproved, boolean completed, boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy){
        super(itemId, menuId, customerId, orderTime, isApproved, completed, isDeleted,  isActive, createdDate, createdBy);
    }
}

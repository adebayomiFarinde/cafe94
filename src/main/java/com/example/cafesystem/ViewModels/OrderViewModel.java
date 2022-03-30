package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class OrderViewModel extends Order {
    public OrderViewModel(UUID itemId, UUID customerId, LocalDate orderTime, boolean isApproved, boolean completed, boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy){
        super(itemId, customerId, orderTime, isApproved, completed, isDeleted,  isActive, createdDate, createdBy);
    }
}

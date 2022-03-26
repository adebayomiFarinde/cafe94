package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Order;

import java.time.LocalDateTime;
import java.util.UUID;

public class UpdateOrder extends Order {
    public UpdateOrder(UUID itemId, UUID customerId, LocalDateTime orderTime, boolean isApproved, boolean completed) {
        super(itemId, customerId, orderTime, isApproved, completed);
    }
}
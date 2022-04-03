package com.example.cafesystem.Repository;

import com.example.cafesystem.Order;
import com.example.cafesystem.ViewModels.OrderViewModel;
import com.example.cafesystem.ViewModels.UpdateOrder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * This is an abstract class which provides methods for the OrderRepository class.
 */

public abstract class IOrderRepository {
    public abstract UUID createOrder(OrderViewModel order);
    public abstract void updateOrder(UUID orderId, UpdateOrder updateOrder);
    public abstract void deleteOrder(UUID orderId);
    public abstract Order getOrderById(UUID orderId);
    public abstract List<Order> getAllOrdersByDate(LocalDate referencedDate);
    public abstract List<Order> getAllOrderByCustomerId(UUID customerID);
    public abstract void markOrderAsCompleted(UUID orderId);
}

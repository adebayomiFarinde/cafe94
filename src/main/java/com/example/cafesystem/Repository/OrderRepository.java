package com.example.cafesystem.Repository;

import com.example.cafesystem.MockData;
import com.example.cafesystem.Order;
import com.example.cafesystem.ViewModels.OrderViewModel;
import com.example.cafesystem.ViewModels.UpdateOrder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderRepository extends IOrderRepository{
    @Override
    public UUID createOrder(OrderViewModel order) {
        ArrayList<Order> all = MockData.getOrders();
        UUID newId = UUID.randomUUID();
        all.add(new Order(newId, order.getCustomerId(), order.getOrderTime(),
                order.getApproved(), order.getCompleted()));

        MockData.setOrders(all);

        return newId;    }

    @Override
    public void updateOrder(UUID orderId, UpdateOrder updateOrder) {
        ArrayList<Order> all = MockData.getOrders();
        Order order =  getOrderById(orderId);

        int index = all.indexOf(order);

        order.setOrderTime(updateOrder.getOrderTime());
        order.setApproved(updateOrder.getApproved());
        order.setCompleted(updateOrder.getCompleted());
        order.setCustomerId(updateOrder.getCustomerId());

        all.set(index, order);

        MockData.setOrders(all);
    }

    @Override
    public void deleteOrder(UUID orderId) {
        ArrayList<Order> all = MockData.getOrders();
        all.removeIf(x -> x.getId() == orderId);

        MockData.setOrders(all);

        return;
    }

    @Override
    public Order getOrderById(UUID orderId) {
        ArrayList<Order> all = MockData.getOrders();

        return all.stream().filter(x -> x.getId() == orderId)
                .findAny().orElse(null);
    }

    @Override
    public List<Order> getAllOrdersByDate(LocalDate referencedDate) {
        ArrayList<Order> all = MockData.getOrders();

        return all.stream().filter(x -> x.getOrderTime() == referencedDate)
                .collect(Collectors.toList());

    }

    @Override
    public List<Order> getAllOrderByCustomerId(UUID customerID) {
        ArrayList<Order> all = MockData.getOrders();

        return all.stream().filter(x -> x.getCustomerId() == customerID)
                .collect(Collectors.toList());
    }

    @Override
    public void markOrderAsCompleted(UUID orderId) {
        ArrayList<Order> all = MockData.getOrders();
        Order order =  getOrderById(orderId);

        int index = all.indexOf(order);

        order.setCompleted(true);

        all.set(index, order);

        MockData.setOrders(all);
    }
}

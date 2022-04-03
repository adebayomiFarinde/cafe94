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

/**
 *  This class is a repository class that implements all the abstract methods in the IOrderRepository class.
 */

public class OrderRepository extends IOrderRepository{

    /**
     * Create a new order, add it to the repository.
     * @param order  The order to be added.
     * @return id of the new Order.
     */
    @Override
    public UUID createOrder(OrderViewModel order) {
        ArrayList<Order> all = MockData.getOrders();
        UUID newId = UUID.randomUUID();
        all.add(new Order(newId, order.getMenuId(), order.getCustomerId(), order.getOrderTime(),
                order.getApproved(), order.getCompleted(),
                false, true, LocalDate.now(), null));

        MockData.setOrders(all);

        return newId;
    }

    /**
     * Update an Order.
     * @param orderId The orerID of the Order to be updated.
     * @param updateOrder The Order object.
     */
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

    /**
     * Delete an order.
     * @param orderId Order Id used to delete corresponding Order.
     */
    @Override
    public void deleteOrder(UUID orderId) {
        ArrayList<Order> all = MockData.getOrders();
        all.removeIf(x -> x.getId().equals(orderId));

        MockData.setOrders(all);

        return;
    }

    /**
     * Get an Order based on Id component.
     * @param orderId  The order Id component.
     * @return The order corresponding to orderID param passed.
     */
    @Override
    public Order getOrderById(UUID orderId) {
        ArrayList<Order> all = MockData.getOrders();

        return all.stream().filter(x -> x.getId().equals(orderId))
                .findAny().orElse(null);
    }

    /**
     * Get all orders based on the reference Date.
     * @param referencedDate The reference date used to identify each order.
     * @return The list of all orders made on the specific date.
     */
    @Override
    public List<Order> getAllOrdersByDate(LocalDate referencedDate) {
        ArrayList<Order> all = MockData.getOrders();

        return all.stream().filter(x -> x.getOrderTime().equals(referencedDate))
                .collect(Collectors.toList());

    }

    /**
     * Get all orders based on the customerId.
     * @param customerID  The customerID used to identify each order.
     * @return The list of all orders corresponding to the customerID.
     */
    @Override
    public List<Order> getAllOrderByCustomerId(UUID customerID) {
        ArrayList<Order> all = MockData.getOrders();

        return all.stream().filter(x -> x.getCustomerId().equals(customerID))
                .collect(Collectors.toList());
    }

    /**
     * Mark an order as completed.
     * @param orderId The orderId component.
     */
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

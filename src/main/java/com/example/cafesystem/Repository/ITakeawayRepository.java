package com.example.cafesystem.Repository;

import com.example.cafesystem.Order;
import com.example.cafesystem.Takeaway;
import com.example.cafesystem.ViewModels.OrderViewModel;
import com.example.cafesystem.ViewModels.TakewayViewModel;
import com.example.cafesystem.ViewModels.UpdateOrder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public abstract class ITakeawayRepository {
    public abstract UUID createTakeaway(TakewayViewModel takeaway);
    public abstract void updateTakeaway(UUID takeawayId, Takeaway takeawayOrder);
    public abstract void deleteTakeaway(UUID takeawayId);
    public abstract Takeaway getTakeawayById(UUID takeawayId);
    public abstract List<Takeaway> getAllTakeawaysByDate(LocalDate referencedDate);
    public abstract List<Takeaway> getAllTakeawayByCustomerId(UUID customerID);
    public abstract void markOrderAsCompleted(UUID orderId);
    public abstract List<Takeaway> getAllTakeaway();
    public abstract void deleteTakeawayByReferenceCode(String referenceCode);
}

package com.example.cafesystem.ViewModels;

import com.example.cafesystem.Takeaway;

import java.time.LocalDate;
import java.util.UUID;

public class TakewayViewModel extends Takeaway {

    public TakewayViewModel(UUID id, UUID menuId, String referenceCode, boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy) {
        super(id, menuId, referenceCode, isActive, isDeleted, createdDate, createdBy);
    }
}

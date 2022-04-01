package com.example.cafesystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class Takeaway extends BaseEntity  {

    private LocalDateTime pickupTime;
    private UUID menuId;
    private String referenceCode;

    public Takeaway(UUID id, UUID menuId, String referenceCode, boolean isActive, boolean isDeleted, LocalDate createdDate, UUID createdBy){
        super(id,isDeleted,  isActive, createdDate, createdBy);
        this.referenceCode = referenceCode;
        this.menuId = menuId;
    }
    public UUID getMenuId() {
        return menuId;
    }

    public void setMenuId(UUID menuId) {
        this.menuId = menuId;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }
}


package com.example.cafesystem;

public class TakeawayVM {
    private String menuName;
    private String referenceCode;
    private String isActive;
    private String isDeleted;
    private String createdDate;
    private String createdBy;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String active) {
        isActive = active;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String deleted) {
        isDeleted = deleted;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public TakeawayVM(String menuName, String referenceCode,
                      String isActive, String isDeleted, String createdDate, String createdBy){
        this. menuName = menuName;
        this.referenceCode = referenceCode;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }
}

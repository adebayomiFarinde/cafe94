package com.example.cafesystem;

/**
 * This class represents a view model for the Takeaway class (menuName, referenceCode,isActive,  isDeleted, createdDate, createdBy).
 * This class exposes certain takeaway properties.
 */

public class TakeawayVM {
    private String menuName;
    private String referenceCode;
    private String isActive;
    private String isDeleted;
    private String createdDate;
    private String createdBy;

    /**
     * Get the Menu Name component.
     * @return The Menu Name.
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * Set the Menu Name component.
     * @param menuName The new Menu Name.
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * Get the Reference Code component.
     * @return The reference Code.
     */
    public String getReferenceCode() {
        return referenceCode;
    }

    /**
     * Set the Reference Code component.
     * @param referenceCode The new Reference Code.
     */
    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    /**
     * Get whether is it active or not
     * @return The isActive component.
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * Set whether is it active or not.
     * @param active The new isActive.
     */
    public void setIsActive(String active) {
        isActive = active;
    }

    /**
     * Get whether it is deleted or not.
     * @return The isDeleted component.
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * Set whether it is deleted or not.
     * @param deleted The new isDeleted component.
     */
    public void setIsDeleted(String deleted) {
        isDeleted = deleted;
    }

    /**
     * Get the creation Date component.
     * @return Creation Date.
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Set the creation Date component.
     * @param createdDate The new creation Date.
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Get Who created the TakeawayVM component.
     * @return The createdBy.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Set Who created the TakeawayVM component.
     * @param createdBy Teh new TakeawayVM.
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Create a Takeaway instance with the following attributes:
     * @param menuName The Menu name.
     * @param referenceCode The reference Code.
     * @param isActive Whether it is active or not.
     * @param isDeleted Whether it is deleted or not.
     * @param createdDate The creation Date.
     * @param createdBy Who created the Person instance.
     */
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

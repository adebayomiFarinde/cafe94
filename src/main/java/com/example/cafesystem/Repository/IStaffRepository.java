package com.example.cafesystem.Repository;


import com.example.cafesystem.Booking;
import com.example.cafesystem.Staff;
import com.example.cafesystem.ViewModels.StaffViewModel;
import com.example.cafesystem.ViewModels.UpdateStaffViewModel;

import java.util.List;
import java.util.UUID;

public abstract class IStaffRepository {
    public abstract UUID createStaff(StaffViewModel staff);
    public abstract void updateStaff(UUID staffId, UpdateStaffViewModel staff);
    public abstract void deleteStaff(UUID staffId);
    public abstract Staff getStaffId(UUID staffId);
    public abstract void deleteStaffByEmail(String email);
    public abstract Staff getStaffByEmailPassword(String email, String password);
    public abstract int numberOfActiveStaff();
    public abstract List<Staff> getAllStaff();

}

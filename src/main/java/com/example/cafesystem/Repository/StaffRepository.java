package com.example.cafesystem.Repository;

import com.example.cafesystem.Booking;
import com.example.cafesystem.Customer;
import com.example.cafesystem.MockData;
import com.example.cafesystem.Staff;
import com.example.cafesystem.ViewModels.StaffViewModel;
import com.example.cafesystem.ViewModels.UpdateStaffViewModel;

import java.util.ArrayList;
import java.util.UUID;

public class StaffRepository extends IStaffRepository{
    @Override
    public UUID createStaff(StaffViewModel staff) {
        ArrayList<Staff> all = MockData.getStaff();
        UUID newId = UUID.randomUUID();
        all.add(new Staff(newId, staff.getfName(), staff.getlName(),
                staff.getPassword(), staff.getAddress(), staff.getPortfolio(), staff.getEmail()));

        MockData.setStaff(all);

        return newId;
    }
    @Override
    public Staff getStaffByEmailPassword(String email, String password) {
        ArrayList<Staff> all = MockData.getStaff();

        return all.stream().filter(x -> x.getEmail() == email && x.getPassword() == password).findAny().orElse(null);
    }

    @Override
    public void updateStaff(UUID staffId, UpdateStaffViewModel staffVM) {
        ArrayList<Staff> all = MockData.getStaff();
        Staff staff =  getStaffId(staffId);

        int index = all.indexOf(staff);

        staff.setAddress(staffVM.getAddress());
        staff.setPortfolio(staffVM.getPortfolio());
        staff.setEmail(staffVM.getEmail());
        staff.setfName(staffVM.getfName());
        staff.setPassword(staffVM.getPassword());
        staff.setlName(staffVM.getlName());

        all.set(index, staff);

        MockData.setStaff(all);
    }

    @Override
    public void deleteStaff(UUID staffId) {
        ArrayList<Staff> all = MockData.getStaff();
        all.removeIf(x -> x.getId() == staffId);

        MockData.setStaff(all);

        return;
    }

    @Override
    public void deleteStaffByEmail(String email) {
        ArrayList<Staff> all = MockData.getStaff();

        Staff staff = all.stream().filter(x -> x.getEmail() == email).findAny().orElse(null);

        if(staff != null){
            deleteStaff(staff.getId());
        }
    }

    @Override
    public Staff getStaffId(UUID staffId) {
        ArrayList<Staff> all = MockData.getStaff();

        return all.stream().filter(x -> x.getId() == staffId).findAny().orElse(null);
    }
}

package com.example.cafesystem.Repository;

import com.example.cafesystem.Booking;
import com.example.cafesystem.Customer;
import com.example.cafesystem.MockData;
import com.example.cafesystem.Staff;
import com.example.cafesystem.ViewModels.StaffViewModel;
import com.example.cafesystem.ViewModels.UpdateStaffViewModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StaffRepository extends IStaffRepository{
    @Override
    public UUID createStaff(StaffViewModel staff) {
        ArrayList<Staff> all = MockData.getStaff();

        try {
            UUID newId = UUID.randomUUID();
            all.add(new Staff(newId, staff.getfName(), staff.getlName(),
                    staff.getPassword(), staff.getAddress(), staff.getPortfolio(), staff.getEmail(),
                    true, false, LocalDate.now(), UUID.randomUUID()));

            MockData.setStaff(all);

            return newId;

        } catch (Exception ex){
            return null;
        }

    }

    @Override
    public int numberOfActiveStaff() {
        List<Staff> list = MockData.getStaff();
        int count =0;

        for(Staff staff : list){
            if(staff.getActive() && !staff.isDeleted()){
                count ++;
            }
        }

        return count;
    }

    @Override
    public Staff getStaffByEmailPassword(String email, String password) {
        ArrayList<Staff> all = MockData.getStaff();

        return all.stream().filter(x -> x.getEmail().equals(email) && x.getPassword().equals(password)).findAny().orElse(null);
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
        all.removeIf(x -> x.getId().equals(staffId));

        MockData.setStaff(all);

        return;
    }

    @Override
    public void deleteStaffByEmail(String email) {
        ArrayList<Staff> all = MockData.getStaff();

        Staff staff = all.stream().filter(x -> x.getEmail().equals(email)).findAny().orElse(null);

        if(staff != null){
            deleteStaff(staff.getId());
        }
    }

    @Override
    public Staff getStaffId(UUID staffId) {
        ArrayList<Staff> all = MockData.getStaff();

        return all.stream().filter(x -> x.getId().equals(staffId)).findAny().orElse(null);
    }
}

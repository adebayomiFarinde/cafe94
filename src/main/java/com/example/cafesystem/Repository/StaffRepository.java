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
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *  This class is a repository class that implements all the abstract methods in the IStaffRepository class.
 */

public class StaffRepository extends IStaffRepository{

    /**
     * Create a new staff, add it to the repository.
     * @param staff  The staff to be added.
     * @return id of the new Staff.
     */
    @Override
    public UUID createStaff(StaffViewModel staff) {
        ArrayList<Staff> all = MockData.getStaff();

        try {
            UUID newId = UUID.randomUUID();
            all.add(new Staff(newId, staff.getfName(), staff.getlName(),
                    staff.getPassword(), staff.getAddress(), staff.getPortfolio(),
                    staff.getEmail().toLowerCase(Locale.ROOT),
                    true, false, LocalDate.now(), UUID.randomUUID()));

            MockData.setStaff(all);

            return newId;

        } catch (Exception ex){
            return null;
        }

    }

    /**
     * Get the number of active staff members.
     * @return The number of active staff members.
     */
    @Override
    public int numberOfActiveStaff() {
        List<Staff> list = MockData.getStaff();
        int count =0;

        for(Staff staff : list){
            if(staff.getActive() && !staff.getIsDeleted()){
                count ++;
            }
        }

        return count;
    }

    /**
     * Get staff based on staff's email and password.
     * @param email The email used to identify each staff.
     * @param password The password used to identify each staff.
     * @return Staff with the corresponding email and password.
     */
    @Override
    public Staff getStaffByEmailPassword(String email, String password) {
        ArrayList<Staff> all = MockData.getStaff();

        return all.stream().filter(x -> x.getEmail().equals(email) && x.getPassword().equals(password)).findAny().orElse(null);
    }

    /**
     * Get list of all staff.
     * @return The list containing all staff.
     */
    @Override
    public List<Staff> getAllStaff() {
        ArrayList<Staff> all = MockData.getStaff();

        return all.stream().filter(x -> !x.getIsDeleted()).collect(Collectors.toList());
    }

    /**
     * Update a Staff member.
     * @param staffId The staffID of the Staff member to be updated.
     * @param staffVM The Staff object.
     */
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

    /**
     * Delete a staff by passing her staff ID.
     * @param staffId Staff ID used to delete a staff member.
     */
    @Override
    public void deleteStaff(UUID staffId) {
        ArrayList<Staff> all = MockData.getStaff();
        all.removeIf(x -> x.getId().equals(staffId));

        MockData.setStaff(all);

        return;
    }

    /**
     * Delete a staff member by passing her email.
     * @param email Email used to delete a staff member.
     */
    @Override
    public void deleteStaffByEmail(String email) {
        ArrayList<Staff> all = MockData.getStaff();

        Staff staff = all.stream().filter(x -> x.getEmail().equals(email)).findAny().orElse(null);

        if(staff != null){
            deleteStaff(staff.getId());
        }
    }

    /**
     * Get staff based on the staff's ID.
     * @param staffId The staff ID used to identify each staff member.
     * @return Staff corresponding to the staffId.
     */
    @Override
    public Staff getStaffId(UUID staffId) {
        ArrayList<Staff> all = MockData.getStaff();

        return all.stream().filter(x -> x.getId().equals(staffId)).findAny().orElse(null);
    }
}

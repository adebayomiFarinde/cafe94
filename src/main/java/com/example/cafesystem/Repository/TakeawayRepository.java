package com.example.cafesystem.Repository;

import com.example.cafesystem.MockData;
import com.example.cafesystem.Takeaway;
import com.example.cafesystem.ViewModels.TakewayViewModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TakeawayRepository extends ITakeawayRepository{
    @Override
    public UUID createTakeaway(TakewayViewModel takewayViewModel) {
        ArrayList<Takeaway> all = MockData.getTakeaways();
        UUID newId = UUID.randomUUID();

        UUID createdBy =  MockData.getCustomerId().equals(UUID.fromString("00000000-0000-0000-0000-000000000000")) ?
                MockData.getStaffId(): MockData.getCustomerId();

        all.add(new Takeaway(newId, takewayViewModel.getMenuId(), takewayViewModel.getReferenceCode(),
                true, false, LocalDate.now(), createdBy));

        MockData.setTakeaways(all);

        return newId;
    }

    @Override
    public void updateTakeaway(UUID takeawayId, Takeaway updateTakeaway) {
        ArrayList<Takeaway> all = MockData.getTakeaways();
        Takeaway takeaway  =  getTakeawayById(takeawayId);

        int index = all.indexOf(takeaway);

        takeaway.setMenuId(updateTakeaway.getMenuId());
        takeaway.setActive(updateTakeaway.getActive());
        takeaway.setModifiedDate(updateTakeaway.getModifiedDate());
        takeaway.setModifiedBy(updateTakeaway.getModifiedBy());

        all.set(index, takeaway);

        MockData.setTakeaways(all);
    }

    @Override
    public void deleteTakeaway(UUID takeawayId) {
        ArrayList<Takeaway> all = MockData.getTakeaways();
        all.removeIf(x -> x.getId().equals(takeawayId));

        MockData.setTakeaways(all);
    }

    @Override
    public Takeaway getTakeawayById(UUID takeawakeId) {
        ArrayList<Takeaway> all = MockData.getTakeaways();

        return all.stream().filter(x -> x.getId().equals(takeawakeId))
                .findAny().orElse(null);
    }

    @Override
    public List<Takeaway> getAllTakeawaysByDate(LocalDate referencedDate) {
        ArrayList<Takeaway> all = MockData.getTakeaways();

        return all.stream().filter(x -> x.getCreatedDate().equals(referencedDate))
                .collect(Collectors.toList());

    }

    @Override
    public List<Takeaway> getAllTakeawayByCustomerId(UUID customerID) {
        ArrayList<Takeaway> all = MockData.getTakeaways();

        return all.stream().filter(x -> x.getCreatedBy().equals(customerID))
                .collect(Collectors.toList());
    }

    @Override
    public void markOrderAsCompleted(UUID takeawayId) {
        ArrayList<Takeaway> all = MockData.getTakeaways();
        Takeaway takeaway =  getTakeawayById(takeawayId);

        int index = all.indexOf(takeaway);

        takeaway.setActive(false);

        all.set(index, takeaway);

        MockData.setTakeaways(all);
    }

    @Override
    public List<Takeaway> getAllTakeaway() {
        List<Takeaway> all = MockData.getTakeaways();

        return all.stream().filter(x -> !x.getIsDeleted()).collect(Collectors.toList());
    }

    @Override
    public void deleteTakeawayByReferenceCode(String referenceCode) {
        ArrayList<Takeaway> all = MockData.getTakeaways();
        all.removeIf(x -> x.getReferenceCode().equals(referenceCode));

        MockData.setTakeaways(all);
    }
}

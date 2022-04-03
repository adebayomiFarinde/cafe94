package com.example.cafesystem.Repository;

import com.example.cafesystem.MockData;
import com.example.cafesystem.Takeaway;
import com.example.cafesystem.ViewModels.TakewayViewModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *  This class is a repository class that implements all the abstract methods in the ITakeawayRepository class.
 */

public class TakeawayRepository extends ITakeawayRepository{

    /**
     * Create a new Takeaway Order, add it to the repository.
     * @param takewayViewModel The Takeaway to be added.
     * @return id of the new Takeaway.
     */
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

    /**
     * Update a Takeaway Order.
     * @param takeawayId The TakeawayId of the Takeaway to be updated.
     * @param updateTakeaway The Takeaway object.
     */
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

    /**
     * Delete a takeaway by passing its takeawayID.
     * @param takeawayId  takeawayId used to delete a takeaway.
     */
    @Override
    public void deleteTakeaway(UUID takeawayId) {
        ArrayList<Takeaway> all = MockData.getTakeaways();
        all.removeIf(x -> x.getId().equals(takeawayId));

        MockData.setTakeaways(all);
    }

    /**
     * Get takeaway based on the takeaway's ID.
     * @param takeawakeId The takeawayId used to identify each takeaway.
     * @return  Takeaway corresponding to the takeawayId.
     */
    @Override
    public Takeaway getTakeawayById(UUID takeawakeId) {
        ArrayList<Takeaway> all = MockData.getTakeaways();

        return all.stream().filter(x -> x.getId().equals(takeawakeId))
                .findAny().orElse(null);
    }

    /**
     * Get all takeaway orders based on the reference Date.
     * @param referencedDate The reference date used to identify each takeaway order.
     * @return The list of all takeaway orders made on the specific date.
     */
    @Override
    public List<Takeaway> getAllTakeawaysByDate(LocalDate referencedDate) {
        ArrayList<Takeaway> all = MockData.getTakeaways();

        return all.stream().filter(x -> x.getCreatedDate().equals(referencedDate))
                .collect(Collectors.toList());

    }

    /**
     * Get all takeaway orders based on the customerId.
     * @param customerID The customerID used to identify each takeaway order.
     * @return The list of all takeaway orders corresponding to the customerID.
     */
    @Override
    public List<Takeaway> getAllTakeawayByCustomerId(UUID customerID) {
        ArrayList<Takeaway> all = MockData.getTakeaways();

        return all.stream().filter(x -> x.getCreatedBy().equals(customerID))
                .collect(Collectors.toList());
    }

    /**
     * Mark a takeaway as completed.
     * @param takeawayId The takeawayId component.
     */
    @Override
    public void markOrderAsCompleted(UUID takeawayId) {
        ArrayList<Takeaway> all = MockData.getTakeaways();
        Takeaway takeaway =  getTakeawayById(takeawayId);

        int index = all.indexOf(takeaway);

        takeaway.setActive(false);

        all.set(index, takeaway);

        MockData.setTakeaways(all);
    }

    /**
     * Get list of all takeaways.
     * @return The list containing all takeaways.
     */
    @Override
    public List<Takeaway> getAllTakeaway() {
        List<Takeaway> all = MockData.getTakeaways();

        return all.stream().filter(x -> !x.getIsDeleted()).collect(Collectors.toList());
    }

    /**
     * Delete a takeaway by passing its reference code.
     * @param referenceCode Code used to delete a takeaway.
     */
    @Override
    public void deleteTakeawayByReferenceCode(String referenceCode) {
        ArrayList<Takeaway> all = MockData.getTakeaways();
        all.removeIf(x -> x.getReferenceCode().equals(referenceCode));

        MockData.setTakeaways(all);
    }
}

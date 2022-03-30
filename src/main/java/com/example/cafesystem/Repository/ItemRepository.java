package com.example.cafesystem.Repository;

import com.example.cafesystem.*;
import com.example.cafesystem.ViewModels.ItemViewModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class ItemRepository extends IItemRepository{
    @Override
    public UUID createItem(ItemViewModel item) {
        ArrayList<Item> all = MockData.getItems();
        UUID newId = UUID.randomUUID();
        all.add(new Item(newId, item.getStaffId(), item.getItemName(),
                item.getDescription(),
                item.getItemType(), true,
                false, LocalDate.now(), null));

        MockData.setItems(all);

        return newId;
    }


    @Override
    public void deleteItem(UUID itemId) {
        ArrayList<Item> all = MockData.getItems();
        all.removeIf(x -> x.getId().equals(itemId));

        MockData.setItems(all);

        return;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> list = MockData.getItems();

        list.sort(Comparator.comparing(Item::getCreatedDate));

        return list;
    }

    @Override
    public Item getItemId(UUID itemId) {
        ArrayList<Item> all = MockData.getItems();

        return all.stream().filter(x -> x.getId().equals(itemId)).findAny().orElse(null);
    }
}

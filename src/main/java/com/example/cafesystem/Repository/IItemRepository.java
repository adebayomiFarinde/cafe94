package com.example.cafesystem.Repository;

import com.example.cafesystem.Item;
import com.example.cafesystem.ViewModels.ItemViewModel;

import java.util.List;
import java.util.UUID;

public abstract class IItemRepository {
    public abstract UUID createItem(ItemViewModel item);
    public abstract void deleteItem(UUID itemId);
    public abstract Item getItemId(UUID itemId);
    public abstract List<Item> getAllItems();

}

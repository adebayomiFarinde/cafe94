package com.example.cafesystem.Repository;

import com.example.cafesystem.Menu;
import com.example.cafesystem.MockData;
import com.example.cafesystem.ViewModels.MenuViewModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MenuRepository extends IMenuRepository{
    @Override
    public UUID createMenu(MenuViewModel menu) {
        ArrayList<Menu> all = MockData.getMenu();
        UUID newId = UUID.randomUUID();
        all.add(new Menu(newId, menu.getName(), menu.getDescription(), true,
                false, LocalDate.now(), null));

        MockData.setMenu(all);

        return newId;
    }

    @Override
    public void deleteMenu(UUID menuId) {
        ArrayList<Menu> all = MockData.getMenu();
        all.removeIf(x -> x.getId().equals(menuId));

        MockData.setMenu(all);
    }

    @Override
    public List<Menu> getAllMenu() {
        List<Menu> list = MockData.getMenu().stream().filter(x -> x.getActive()
                && !x.getIsDeleted()).collect(Collectors.toList());

        list.sort(Comparator.comparing(Menu::getCreatedDate));

        return list;
    }

    @Override
    public Menu getMenuId(UUID menuId) {
        ArrayList<Menu> all = MockData.getMenu();

        return all.stream().filter(x -> x.getId()
                .equals(menuId)).findAny().orElse(null);
    }

    @Override
    public Menu getMenuByName(String menuName) {
        ArrayList<Menu> all = MockData.getMenu();

        return all.stream().filter(x -> x.getName()
                .equals(menuName)).findAny().orElse(null);
    }

    @Override
    public void deleteMenuByName(String menuName) {
        ArrayList<Menu> all = MockData.getMenu();
        all.removeIf(x -> x.getName().equals(menuName));

        MockData.setMenu(all);
    }
}

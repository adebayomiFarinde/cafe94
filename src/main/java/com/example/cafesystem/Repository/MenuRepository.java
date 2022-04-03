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

/**
 *  This class is a repository class that implements all the abstract methods in the IMenuRepository class.
 */

public class MenuRepository extends IMenuRepository{

    /** Create a new menu, add it to the repository.
     * @param menu  The menu to be added.
     * @return id of the new Menu.
     */
    @Override
    public UUID createMenu(MenuViewModel menu) {
        ArrayList<Menu> all = MockData.getMenu();
        UUID newId = UUID.randomUUID();
        all.add(new Menu(newId, menu.getName(), menu.getDescription(), true,
                false, LocalDate.now(), null));

        MockData.setMenu(all);

        return newId;
    }

    /**
     * Delete a menu by passing its menuId.
     * @param menuId menuId used to delete Menu.
     */
    @Override
    public void deleteMenu(UUID menuId) {
        ArrayList<Menu> all = MockData.getMenu();
        all.removeIf(x -> x.getId().equals(menuId));

        MockData.setMenu(all);
    }


    /** Get list of all Menus.
     * @return The list containing all Menus.
     */
    @Override
    public List<Menu> getAllMenu() {
        List<Menu> list = MockData.getMenu().stream().filter(x -> x.getActive()
                && !x.getIsDeleted()).collect(Collectors.toList());

        list.sort(Comparator.comparing(Menu::getCreatedDate));

        return list;
    }

    /**
     * Get menu based on the menu's Id.
     * @param menuId The menu ID used to identify each Menu.
     * @return Menu corresponding to the menuId.
     */
    @Override
    public Menu getMenuId(UUID menuId) {
        ArrayList<Menu> all = MockData.getMenu();

        return all.stream().filter(x -> x.getId()
                .equals(menuId)).findAny().orElse(null);
    }

    /**
     * Get menu based on the menu's name.
     * @param menuName The menu name used to identify each Menu.
     * @return Menu corresponding to the menuId.
     */
    @Override
    public Menu getMenuByName(String menuName) {
        ArrayList<Menu> all = MockData.getMenu();

        return all.stream().filter(x -> x.getName()
                .equals(menuName)).findAny().orElse(null);
    }

    /**
     * Delete a menu by passing its name.
     * @param menuName The name used to delete menu.
     */
    @Override
    public void deleteMenuByName(String menuName) {
        ArrayList<Menu> all = MockData.getMenu();
        all.removeIf(x -> x.getName().equals(menuName));

        MockData.setMenu(all);
    }
}

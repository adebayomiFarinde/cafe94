package com.example.cafesystem.Repository;

import com.example.cafesystem.Menu;
import com.example.cafesystem.ViewModels.MenuViewModel;

import java.util.List;
import java.util.UUID;

/**
 * This is an abstract class which provides methods for the MenuRepository class.
 */
public abstract class IMenuRepository {
    public abstract UUID createMenu(MenuViewModel item);
    public abstract void deleteMenu(UUID menuId);
    public abstract Menu getMenuId(UUID menuId);
    public abstract List<Menu> getAllMenu();
    public abstract Menu getMenuByName(String menuName);
    public abstract void deleteMenuByName(String menuName);
}

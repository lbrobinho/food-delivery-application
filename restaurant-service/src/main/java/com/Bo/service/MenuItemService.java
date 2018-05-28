package com.Bo.service;

import com.Bo.model.MenuItem;

import java.util.List;

public interface MenuItemService {
    List<MenuItem> findAllByRestaurantId(String rid);
    void createMenuItem(MenuItem menuItem);
    void uploadMenuItems(List<MenuItem> menuItems);
}

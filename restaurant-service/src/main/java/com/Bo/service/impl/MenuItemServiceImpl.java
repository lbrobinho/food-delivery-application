package com.Bo.service.impl;

import com.Bo.model.MenuItem;
import com.Bo.repository.MenuItemRepository;
import com.Bo.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {
    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItem> findAllByRestaurantId(String rid) {
        return menuItemRepository.findAllByRestaurantId(rid);
    }

    @Override
    public void createMenuItem(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
    }

    @Override
    public void uploadMenuItems(List<MenuItem> menuItems) {
        menuItemRepository.save(menuItems);
    }
}

package com.Bo.service.Impl;

import com.Bo.domain.MenuItem;
import com.Bo.repository.MenuItemRepository;
import com.Bo.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public void uploadMenuItem(List<MenuItem> menuItems) {  menuItemRepository.save(menuItems); }

    @Override
    public Page<MenuItem> findAll(Pageable pageable) { return menuItemRepository.findAll(pageable); }

    @Override
    public Page<MenuItem> findByMenuId(int menuId, Pageable pageable) {
        return menuItemRepository.findAllByMenuId(menuId, pageable);
    }

    @Override
    public MenuItem findById(int id) { return menuItemRepository.findOne(id); }

    @Override
    public void deleteAll() { menuItemRepository.deleteAll(); }

    @Override
    public void deleteById(int id) { menuItemRepository.delete(id);}
}


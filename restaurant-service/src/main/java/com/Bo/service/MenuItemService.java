package com.Bo.service;

import com.Bo.domain.MenuItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MenuItemService {

    void uploadMenuItem(List<MenuItem> menuItems);

    Page<MenuItem> findAll(Pageable pageable);

    Page<MenuItem> findByMenuId(int menuId, Pageable pageable);

    MenuItem findById(int id);

    void deleteAll();

    void deleteById(int id);
}


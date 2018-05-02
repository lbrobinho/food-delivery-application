package com.Bo.repository;

import com.Bo.domain.MenuItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
    Page<MenuItem> findAllByMenuId(int menuId, Pageable pageable);
 }

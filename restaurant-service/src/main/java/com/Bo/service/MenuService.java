package com.Bo.service;

import com.Bo.domain.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MenuService {

    void uploadMenu(List<Menu> menuList);

    Page<Menu> findAll(Pageable pageable);

    Menu findById(int id);

    void deleteAll();

    void deleteById(int id);
}
package com.Bo.service.Impl;

import com.Bo.domain.Menu;
import com.Bo.repository.MenuRepository;
import com.Bo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository) { this.menuRepository = menuRepository; }


    @Override
    public void uploadMenu(List<Menu> menuList) { menuRepository.save(menuList);
    }

    @Override
    public Page<Menu> findAll(Pageable pageable) { return menuRepository.findAll(pageable);}


    @Override
    public Menu findById(int id) { return  menuRepository.findOne(id); }

    @Override
    public void deleteAll() { menuRepository.deleteAll();}

    @Override
    public void deleteById(int id) { menuRepository.delete(id);}
}




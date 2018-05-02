package com.Bo.service;

import com.Bo.domain.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantService {
    void saveRestaurants(List<Restaurant> restaurantsList);

    Page<Restaurant> findAll(Pageable pageable);

    Page<Restaurant> findByName(String name, Pageable pageable);

    Restaurant findById(int id);

    void deleteAll();

    void deleteById(int id);
}

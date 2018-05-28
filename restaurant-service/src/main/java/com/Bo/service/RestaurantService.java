package com.Bo.service;

import com.Bo.model.Restaurant;

public interface RestaurantService {
    void createRestaurant(Restaurant restaurant);
    Restaurant getRestaurantByName(String name);
}

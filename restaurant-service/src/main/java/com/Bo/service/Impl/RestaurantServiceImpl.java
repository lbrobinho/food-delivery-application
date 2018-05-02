
package com.Bo.service.Impl;

import com.Bo.domain.Restaurant;
import com.Bo.repository.RestaurantRepository;
import com.Bo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {


    private  RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void saveRestaurants(List<Restaurant> restaurantsList) {
        restaurantRepository.save(restaurantsList);
    }

    @Override
    public Page<Restaurant> findAll(Pageable pageable) {
        return restaurantRepository.findAll(pageable);
    }

    @Override
    public Page<Restaurant> findByName(String name, Pageable pageable) {
        return restaurantRepository.findByName(name, pageable);
    }

    @Override
    public Restaurant findById(int id) { return restaurantRepository.findOne(id); }


    @Override
    public void deleteAll() {
        restaurantRepository.deleteAll();
    }

    @Override
    public void deleteById(int id) { restaurantRepository.delete(id);}
}


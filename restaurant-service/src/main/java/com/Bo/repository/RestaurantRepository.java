package com.Bo.repository;

import com.Bo.domain.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

   Page<Restaurant> findByName(String name, Pageable pageable);

}

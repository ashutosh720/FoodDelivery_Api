package com.example.FoodDeliveryApi.Repository;

import com.example.FoodDeliveryApi.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
}

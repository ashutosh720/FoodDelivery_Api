package com.example.FoodDeliveryApi.Repository;

import com.example.FoodDeliveryApi.Model.Food;
import com.example.FoodDeliveryApi.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Integer> {

    @Query(value = "Select * from foods where order_id = :order_id", nativeQuery = true)
    public Food getFoodByOrderId(int order_id);
}

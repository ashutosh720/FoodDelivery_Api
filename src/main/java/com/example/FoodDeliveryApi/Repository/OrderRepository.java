package com.example.FoodDeliveryApi.Repository;

import com.example.FoodDeliveryApi.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query(value = "Select * from orders where user_id = :user_id", nativeQuery = true)
    public List<Order> getOrderByUserId(int user_id);
}

package com.example.FoodDeliveryApi.Service;

import com.example.FoodDeliveryApi.Model.Order;
import com.example.FoodDeliveryApi.Repository.OrderRepository;
import com.example.FoodDeliveryApi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

     @Autowired
    OrderRepository orderRepository;

     @Autowired
    UserRepository userRepository;


    public Order saveOrder(Order order) {
        Order neworder = orderRepository.save(order);
        return neworder;
    }

    public List<Order> getAllOrderByUserId(int user_id){

        List<Order> orderList=orderRepository.getOrderByUserId(user_id);
        return orderList;
    }


}

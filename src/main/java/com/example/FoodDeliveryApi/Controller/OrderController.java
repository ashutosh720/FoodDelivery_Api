package com.example.FoodDeliveryApi.Controller;

import com.example.FoodDeliveryApi.Model.Food;
import com.example.FoodDeliveryApi.Model.Order;
import com.example.FoodDeliveryApi.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/save_order")
    public ResponseEntity saveorder(@RequestBody Order order){
        Order savedFood=orderService.saveOrder(order);
        return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
    }

    @GetMapping("/all_order/user_id/{user_id}")
    public ResponseEntity<List<Order>> getOrderbyUserId(@PathVariable int user_id){

        return ResponseEntity.ok((this.orderService.getAllOrderByUserId(user_id)));
    }


}

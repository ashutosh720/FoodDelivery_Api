package com.example.FoodDeliveryApi.Controller;


import com.example.FoodDeliveryApi.Model.Food;
import com.example.FoodDeliveryApi.Model.User;
import com.example.FoodDeliveryApi.Service.FoodService;
import com.example.FoodDeliveryApi.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

        @Autowired
        private UserService userService;

        @Autowired
        private FoodService foodService;



        @PostMapping("/admin/{user_id}/add_food")
        public ResponseEntity<Food> addFood(@RequestBody Food food , @PathVariable  int user_id) {
            Food savedFood = foodService.addFood(food,user_id);
            return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
        }

        @GetMapping("/users/{food_id}")
        public ResponseEntity<Food> getByFoodId(@PathVariable int food_id) {
            return ResponseEntity.ok(this.foodService.getByFoodId(food_id));
        }

      @GetMapping("/all_food")
      public ResponseEntity<List<Food>> getAllFoods(){

         return ResponseEntity.ok((this.foodService.getAllFoods()));
    }

    @PutMapping("/admin/{user_id}/update_food/{food_id}")
    public ResponseEntity<Food> updateFood(@RequestBody Food food , @PathVariable int user_id, @PathVariable int food_id){

        Food updatedFood= this.foodService.updateFood(food,user_id,food_id);
        return ResponseEntity.ok(updatedFood);
    }

    @DeleteMapping("/admin/{user_id}/delete_food/{food_id}")
    public ResponseEntity<String> deleteFood(@PathVariable int user_id, @PathVariable int food_id){

        this.foodService.deleteFood(user_id,food_id);
        return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/admin/{user_id}/get_food_byOrder_id/{order_id}")
    public ResponseEntity<Food> getFoodByOrderId(@PathVariable int user_id , @PathVariable int order_id){

        return ResponseEntity.ok(this.foodService.getFoodbyOrderId(user_id, order_id));

    }

    }


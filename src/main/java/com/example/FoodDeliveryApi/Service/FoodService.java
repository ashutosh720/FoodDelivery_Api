package com.example.FoodDeliveryApi.Service;

import com.example.FoodDeliveryApi.Model.Food;
import com.example.FoodDeliveryApi.Model.User;
import com.example.FoodDeliveryApi.Repository.FoodRepository;
import com.example.FoodDeliveryApi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FoodService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food addFood(Food food,int user_id){

         User authuser =userRepository.getadmin(user_id);
         if(authuser.getRole().equals("ADMIN")){

             return foodRepository.save(food);
         }

         else {
             throw new RuntimeException("Unauthorised user");
         }

    }

    public Food updateFood(Food food , int user_id , int food_id){

        User authuser =userRepository.getadmin(user_id);

        if(authuser.getRole().equals("ADMIN")){

            Food newFood = foodRepository.findById(food_id).get();
            newFood.setName(food.getName());
            newFood.setPrice(food.getPrice());
            return foodRepository.save(newFood);
        }

        else {
            throw new RuntimeException("Unauthorised user");
        }


    }

    public void deleteFood(int food_id ,int user_id) {

        User authuser =userRepository.getadmin(user_id);

        if(authuser.getRole().equals("ADMIN")){
            Food food = this.foodRepository.findById(food_id).get();
           this.foodRepository.deleteById(food_id);
    }

        else {
            throw new RuntimeException("Unauthorised user");
        }


    }


    public List<Food> getAllFoods(){

        return foodRepository.findAll();
    }

    public Food getByFoodId(int food_id){

        return foodRepository.findById(food_id).get();

    }

    public Food getFoodbyOrderId(int user_id,int order_id){

        User authuser =userRepository.getadmin(user_id);

        if(authuser.getRole().equals("ADMIN")){
            Food food = this.foodRepository.findById(order_id).get();
            return this.foodRepository.getFoodByOrderId(order_id);

        }

        else {
            throw new RuntimeException("Unauthorised user");
        }
    }


}



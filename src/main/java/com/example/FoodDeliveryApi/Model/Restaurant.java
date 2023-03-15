package com.example.FoodDeliveryApi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int restaurant_id;


    @Length(min = 3,max = 30,message = "Name should be between 3 to 20 characters")
    private String name;


    @Length(min = 3,max = 50,message = "Address should be between 3 to 50 characters")
    private String address;


    @OneToMany
    private List<Food> foodList;

}

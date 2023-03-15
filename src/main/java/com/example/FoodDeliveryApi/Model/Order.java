package com.example.FoodDeliveryApi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@Entity
//@Table(name = "orders")
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int order_id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "order_food",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "food_id"))
//    private List<Food> foods;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;


    @JoinColumn(name = "food_id")
    @OneToOne
    private Food food_id;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user_id;


    }
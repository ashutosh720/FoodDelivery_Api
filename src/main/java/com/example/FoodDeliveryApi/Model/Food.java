package com.example.FoodDeliveryApi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int food_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @OneToOne
    private Order order_id;


}
package com.foodapp.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalPrice;
    private String status;

    @ManyToOne
    private User user;
}
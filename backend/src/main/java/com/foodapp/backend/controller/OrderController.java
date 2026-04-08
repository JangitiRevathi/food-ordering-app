package com.foodapp.backend.controller;

import com.foodapp.backend.model.FoodOrder;
import com.foodapp.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public FoodOrder placeOrder(@RequestBody FoodOrder order) {
        return orderService.placeOrder(order);
    }

    @GetMapping
    public List<FoodOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/user/{userId}")
    public List<FoodOrder> getOrders(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }
}

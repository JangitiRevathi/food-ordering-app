package com.foodapp.backend.service;

import com.foodapp.backend.model.FoodOrder;
import com.foodapp.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public FoodOrder placeOrder(FoodOrder order) {
        return orderRepository.save(order);
    }

    public List<FoodOrder> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public List<FoodOrder> getAllOrders() {
        return orderRepository.findAll();
    }
}
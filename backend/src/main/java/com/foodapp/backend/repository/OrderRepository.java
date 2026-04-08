package com.foodapp.backend.repository;

import com.foodapp.backend.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<FoodOrder, Long> {

    List<FoodOrder> findByUserId(Long userId);

}
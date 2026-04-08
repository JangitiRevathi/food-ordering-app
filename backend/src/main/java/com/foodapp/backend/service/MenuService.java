package com.foodapp.backend.service;

import com.foodapp.backend.model.Menu;
import com.foodapp.backend.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> getMenuByRestaurant(Long restaurantId) {
        return menuRepository.findByRestaurantId(restaurantId);
    }
}
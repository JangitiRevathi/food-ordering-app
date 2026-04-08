package com.foodapp.backend.controller;

import com.foodapp.backend.model.Menu;
import com.foodapp.backend.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

     /*@PostMapping
    public Menu addMenu(@RequestBody Menu menu) {
        return menuService.addMenu(menu);
    } */

    @GetMapping("/{restaurantId}")
    public List<Menu> getMenu(@PathVariable Long restaurantId) {
        return menuService.getMenuByRestaurant(restaurantId);
    }
    @PostMapping
    public Menu addMenu(@RequestBody Menu menu) {
        System.out.println("DEBUG NAME: " + menu.getItemName());
        return menuService.addMenu(menu);
    }
}
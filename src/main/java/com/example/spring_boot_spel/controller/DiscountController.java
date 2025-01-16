package com.example.spring_boot_spel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_spel.dto.Order;
import com.example.spring_boot_spel.service.DiscountService;

@RestController
@RequestMapping("api")
public class DiscountController {
    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @PostMapping("/discount")
    public ResponseEntity<Double> generateHaiku(@RequestBody Order order){
        return ResponseEntity.ok(discountService.calculateDiscount(order));
    }
}

package com.example.spring_boot_spel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DiscountRule {
    @Id
    @GeneratedValue
    private Long id;
    private String condition; // SpEL condition
    private double discountPercentage;

    // Constructors
    public DiscountRule() {}

    public DiscountRule(String condition, double discountPercentage) {
        this.condition = condition;
        this.discountPercentage = discountPercentage;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}

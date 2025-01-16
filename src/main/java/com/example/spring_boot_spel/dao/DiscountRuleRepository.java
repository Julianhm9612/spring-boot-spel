package com.example.spring_boot_spel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot_spel.entity.DiscountRule;

public interface DiscountRuleRepository extends JpaRepository<DiscountRule, Long> {
}

package com.example.spring_boot_spel.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.spring_boot_spel.dao.DiscountRuleRepository;
import com.example.spring_boot_spel.entity.DiscountRule;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DiscountRuleRepository repository;

    public DataInitializer(DiscountRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.saveAll(Arrays.asList(
            new DiscountRule("customerAge > 60", 10),
            new DiscountRule("membershipLevel == 'GOLD'", 15),
            new DiscountRule("membershipLevel == 'SILVER'", 5),
            new DiscountRule("totalAmount > 100", 20)
        ));
    }
}

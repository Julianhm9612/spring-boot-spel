package com.example.spring_boot_spel.service;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import com.example.spring_boot_spel.dao.DiscountRuleRepository;
import com.example.spring_boot_spel.dto.Order;
import com.example.spring_boot_spel.entity.DiscountRule;

import java.util.List;

@Service
public class DiscountService {
    private final DiscountRuleRepository discountRuleRepository;

    public DiscountService(DiscountRuleRepository discountRuleRepository) {
        this.discountRuleRepository = discountRuleRepository;
    }

    public double calculateDiscount(Order order) {
        List<DiscountRule> rules = discountRuleRepository.findAll();
        double totalDiscount = 0;

        ExpressionParser parser = new SpelExpressionParser();
        for (DiscountRule rule : rules) {
            StandardEvaluationContext context = new StandardEvaluationContext(order);
            boolean isMatch = parser.parseExpression(rule.getCondition()).getValue(context, Boolean.class);
            if (isMatch) {
                totalDiscount += order.getTotalAmount() * (rule.getDiscountPercentage() / 100);
            }
        }
        return totalDiscount;
    }
}

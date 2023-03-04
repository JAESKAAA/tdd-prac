package com.example.tddprac.product.application.service.dto;

import com.example.tddprac.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public record AddProductRequest(String productName, int price, DiscountPolicy discountPolicy) {

    public AddProductRequest {
        Assert.hasText(productName, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인정책은 필수 입니다.");


    }
}

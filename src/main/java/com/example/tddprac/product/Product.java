package com.example.tddprac.product;

import org.springframework.util.Assert;

class Product {

    private Long id;
    private final String productName;
    private final int price;
    private final DiscountPolicy discountPolicy;

    public Product(String productName, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(productName, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인정책은 필수 입니다.");
        this.productName = productName;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

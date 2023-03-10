package com.example.tddprac.product.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class Product {

    private Long id;
    private String productName;
    private int price;
    private DiscountPolicy discountPolicy;

    @Builder
    public Product(Long id, String productName, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(productName, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인정책은 필수 입니다.");
        Assert.notNull(id, "변환시 id값 필수");
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public Product(String productName, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(productName, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인정책은 필수 입니다.");
        this.productName = productName;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void update(String productName, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(productName, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인정책은 필수 입니다.");
        this.productName = productName;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public int getDiscountedPrice() {
        return discountPolicy.applyDiscount(price);
    }
}

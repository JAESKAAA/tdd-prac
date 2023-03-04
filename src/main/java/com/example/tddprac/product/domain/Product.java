package com.example.tddprac.product.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

/**
 * 현재는 엔티티로 도메인 로직을 같이 쓰고있지만, 도메인 모델과 영속속 엔티티또한 분리되어야 하는게 변경에 유리할 것으로 생각됨
 */

//TODO 도메인 모델로 분리하기
@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int price;
    private DiscountPolicy discountPolicy;

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

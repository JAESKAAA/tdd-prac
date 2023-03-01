package com.example.tddprac.product;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void update() {
        final String productName = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;

        final Product product = new Product(productName, price, discountPolicy);

        final String updateName = "상품 수정";
        final int updatePrice = 20000;
        product.update(updateName, updatePrice, discountPolicy);

        assertThat(product.getProductName()).isEqualTo(updateName);
        assertThat(product.getPrice()).isEqualTo(updatePrice);

    }
}
package com.example.tddprac.order;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.tddprac.product.DiscountPolicy;
import com.example.tddprac.product.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void calculate_non_discounted_total_price() {
        Order order = new Order(new Product("상품명", 1000, DiscountPolicy.NONE), 2);
        int totalPrice = order.getTotalPrice();

        assertThat(totalPrice).isEqualTo(1000 * 2);
    }

    @Test
    void calculate_discounted_total_price() {
        Order order = new Order(new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT), 2);
        int totalPrice = order.getTotalPrice();

        assertThat(totalPrice).isEqualTo(1000 * 2);
    }

}
package com.example.tddprac.product;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DiscountPolicyTest {

    @Test
    void none_discounted_price() {
        final int price = 1000;
        int discountedPrice = DiscountPolicy.NONE.applyDiscount(price);

        assertThat(discountedPrice).isEqualTo(price);
    }

    @Test
    void fix_discounted_price() {
        final int price = 2000;

        int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void over_discounted_price() {
        final int price = 500;

        int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        assertThat(discountedPrice).isEqualTo(0);
    }
}
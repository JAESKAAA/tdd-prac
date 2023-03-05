package com.example.tddprac.order;

import com.example.tddprac.product.domain.Product;
import lombok.Getter;


@Getter
public class Order {

    private Long id;

    private Product product;

    private int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return product.getDiscountedPrice() * quantity;

    }
}

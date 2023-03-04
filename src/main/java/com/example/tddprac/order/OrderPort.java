package com.example.tddprac.order;

import com.example.tddprac.product.Product;

interface OrderPort {

    Product getProductById(Long productId);

    void save(Order order);
}

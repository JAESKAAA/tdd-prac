package com.example.tddprac.product.application.port.out;

import com.example.tddprac.product.domain.Product;

public interface ReadProductPort {

    Product getProduct(Long productId);

}

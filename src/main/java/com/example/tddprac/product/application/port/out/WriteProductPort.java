package com.example.tddprac.product.application.port.out;

import com.example.tddprac.product.domain.Product;

public interface WriteProductPort {

    void save(Product product);
}

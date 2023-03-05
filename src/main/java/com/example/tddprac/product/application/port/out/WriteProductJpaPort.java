package com.example.tddprac.product.application.port.out;

import com.example.tddprac.product.application.service.dto.UpdateProductRequest;
import com.example.tddprac.product.domain.Product;

public interface WriteProductJpaPort {

    Long save(Product product);

    void update(Long productId, UpdateProductRequest request);
}

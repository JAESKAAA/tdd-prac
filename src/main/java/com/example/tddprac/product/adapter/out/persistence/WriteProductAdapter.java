package com.example.tddprac.product.adapter.out.persistence;

import com.example.tddprac.product.application.port.out.WriteProductPort;
import com.example.tddprac.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class WriteProductAdapter implements WriteProductPort {

    private final ProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}

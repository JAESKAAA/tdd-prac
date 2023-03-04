package com.example.tddprac.product.adapter.out.persistence;

import com.example.tddprac.product.application.port.out.ReadProductPort;
import com.example.tddprac.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
class ReadProductAdapter implements ReadProductPort {

    private final ProductRepository productRepository;

    ReadProductAdapter(
        ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }
}

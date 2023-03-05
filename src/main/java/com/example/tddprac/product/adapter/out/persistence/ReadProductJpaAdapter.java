package com.example.tddprac.product.adapter.out.persistence;

import com.example.tddprac.product.adapter.out.persistence.mapper.ProductEntityMapper;
import com.example.tddprac.product.application.port.out.ReadProductJpaPort;
import com.example.tddprac.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ReadProductJpaAdapter implements ReadProductJpaPort {

    private final ProductRepository productRepository;


    @Override
    public Product getProduct(Long productId) {

        ProductEntity productEntity = getProductEntity(productId);

        return ProductEntityMapper.INSTANCE.toModel(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }
}

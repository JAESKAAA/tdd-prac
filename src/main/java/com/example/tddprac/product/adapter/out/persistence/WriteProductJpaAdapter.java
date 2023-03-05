package com.example.tddprac.product.adapter.out.persistence;

import com.example.tddprac.product.adapter.out.persistence.mapper.ProductEntityMapper;
import com.example.tddprac.product.application.port.out.ReadProductJpaPort;
import com.example.tddprac.product.application.port.out.WriteProductJpaPort;
import com.example.tddprac.product.application.service.dto.UpdateProductRequest;
import com.example.tddprac.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class WriteProductJpaAdapter implements WriteProductJpaPort {

    private final ProductRepository productRepository;
    private final ReadProductJpaPort readProductPort;


    @Override
    public Long save(Product product) {

        ProductEntity productEntity = ProductEntityMapper.INSTANCE.toEntity(product);

        productRepository.save(productEntity);
        return productEntity.getId();
    }

    @Override
    public void update(Long productId, UpdateProductRequest request) {
        ProductEntity productEntity = readProductPort.getProductEntity(productId);

        productEntity.update(request.productName(), request.price(), request.discountPolicy());
    }
}

package com.example.tddprac.product.application.service;

import com.example.tddprac.product.application.port.in.ProductWriteUsecase;
import com.example.tddprac.product.application.port.out.WriteProductJpaPort;
import com.example.tddprac.product.application.service.dto.AddProductRequest;
import com.example.tddprac.product.application.service.dto.UpdateProductRequest;
import com.example.tddprac.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductWriteService implements ProductWriteUsecase {

    private final WriteProductJpaPort writeProductJpaPort;


    @Override
    public Long addProduct(AddProductRequest request) {
        final Product product = new Product(request.productName(), request.price(), request.discountPolicy());

        return writeProductJpaPort.save(product);
    }

    @Override
    public void updateProduct(Long productId, UpdateProductRequest request) {
        writeProductJpaPort.update(productId, request);
    }
}

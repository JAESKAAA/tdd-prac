package com.example.tddprac.product.application.service;

import com.example.tddprac.product.application.port.in.ProductWriteUsecase;
import com.example.tddprac.product.application.port.out.ReadProductPort;
import com.example.tddprac.product.application.port.out.WriteProductPort;
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

    private final WriteProductPort writeProductPort;
    private final ReadProductPort readProductPort;


    @Override
    public Long addProduct(AddProductRequest request) {
        final Product product = new Product(request.productName(), request.price(), request.discountPolicy());

        writeProductPort.save(product);
        return product.getId();
    }

    @Override
    public void updateProduct(Long productId, UpdateProductRequest request) {
        Product product = readProductPort.getProduct(productId);
        product.update(request.productName(), request.price(), request.discountPolicy());
    }
}

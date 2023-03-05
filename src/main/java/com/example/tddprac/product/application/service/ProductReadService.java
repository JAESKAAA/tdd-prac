package com.example.tddprac.product.application.service;

import com.example.tddprac.product.application.port.in.ProductReadUsecase;
import com.example.tddprac.product.application.port.out.ReadProductJpaPort;
import com.example.tddprac.product.application.service.dto.GetProductResponse;
import com.example.tddprac.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductReadService implements ProductReadUsecase {

    private final ReadProductJpaPort readProductJpaPort;

    @Override
    public GetProductResponse getProduct(final Long productId) {
       final Product product = readProductJpaPort.getProduct(productId);

        return new GetProductResponse(product.getId(), product.getProductName(), product.getPrice(),
            product.getDiscountPolicy());
    }

}

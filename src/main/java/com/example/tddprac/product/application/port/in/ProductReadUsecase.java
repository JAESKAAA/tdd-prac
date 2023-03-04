package com.example.tddprac.product.application.port.in;

import com.example.tddprac.product.application.service.dto.GetProductResponse;

public interface ProductReadUsecase {

    GetProductResponse getProduct(Long productId);

}

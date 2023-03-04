package com.example.tddprac.product.application.port.in;

import com.example.tddprac.product.application.service.dto.AddProductRequest;
import com.example.tddprac.product.application.service.dto.UpdateProductRequest;

public interface ProductWriteUsecase {

    Long addProduct(final AddProductRequest request);

    void updateProduct(Long productId, UpdateProductRequest request);

}

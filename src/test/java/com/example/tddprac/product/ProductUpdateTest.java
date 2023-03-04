package com.example.tddprac.product;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.tddprac.product.application.port.in.ProductReadUsecase;
import com.example.tddprac.product.application.port.in.ProductWriteUsecase;
import com.example.tddprac.product.application.service.dto.GetProductResponse;
import com.example.tddprac.product.application.service.dto.UpdateProductRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductUpdateTest {

    @Autowired
    private ProductWriteUsecase productWriteUsecase;

    @Autowired
    private ProductReadUsecase productReadUsecase;

    @Test
    @DisplayName("상품 수정 성공 시, 수정된 이름으로 변경된다.")
    void 상품수정() {

        Long productId = productWriteUsecase.addProduct(ProductSteps.상품등록요청_생성());

        final UpdateProductRequest request = ProductSteps.상품수정요청();


        productWriteUsecase.updateProduct(productId, request);
        GetProductResponse updatedProduct = productReadUsecase.getProduct(productId);

        assertThat(updatedProduct.name()).isEqualTo(request.productName());
        assertThat(updatedProduct.price()).isEqualTo(request.price());
    }

}

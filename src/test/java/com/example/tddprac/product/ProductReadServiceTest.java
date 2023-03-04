package com.example.tddprac.product;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.tddprac.product.application.port.in.ProductWriteUsecase;
import com.example.tddprac.product.application.service.dto.GetProductResponse;
import com.example.tddprac.product.application.service.ProductReadService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductReadServiceTest {

    @Autowired
    private ProductReadService productReadService;

    @Autowired
    private ProductWriteUsecase productWriteUsecase;


    @Test
    @DisplayName("상품조회가 가능하다.")
    void 상품조회() {

        productWriteUsecase.addProduct(ProductSteps.상품등록요청_생성());

        final Long productId = 1L;

        GetProductResponse response = productReadService.getProduct(productId);

        assertThat(response).isNotNull();
    }

}

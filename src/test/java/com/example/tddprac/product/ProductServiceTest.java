package com.example.tddprac.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest {

    private ProductService productService;

    @Test
    @DisplayName("상품등록 시, 상품명 + 가격 + 할인 정책을 넣어줘야 성공 한다.")
    void 상품등록() {

        final AddProductRequest request = ProductSteps.상품등록요청_생성();

        productService.addProduct(request);

    }

    @Test
    @DisplayName("상품조회가 가능하다.")
    void 상품조회() {

        productService.addProduct(ProductSteps.상품등록요청_생성());

        final Long productId = 1L;

        GetProductResponse response = productService.getProduct(productId);

        assertThat(response).isNotNull();
    }

}

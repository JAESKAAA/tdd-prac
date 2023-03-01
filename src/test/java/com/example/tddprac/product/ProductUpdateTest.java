package com.example.tddprac.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductUpdateTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductPort productPort;


    @Test
    @DisplayName("상품 수정 성공 시, 수정된 이름으로 변경된다.")
    void 상품수정() {

        Long productId = productService.addProduct(ProductSteps.상품등록요청_생성());

        final UpdateProductRequest request = ProductSteps.상품수정요청();


        productService.updateProduct(productId, request);
        GetProductResponse updatedProduct = productService.getProduct(productId);

        assertThat(updatedProduct.name()).isEqualTo(request.productName());
        assertThat(updatedProduct.price()).isEqualTo(request.price());
    }

}

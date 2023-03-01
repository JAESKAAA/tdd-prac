package com.example.tddprac.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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

        final String updateName = "상품 수정";
        int updatePrice = 20000;
        final UpdateProductRequest request = new UpdateProductRequest(updateName, updatePrice, DiscountPolicy.NONE);


        productService.updateProduct(productId, request);
        GetProductResponse updatedProduct = productService.getProduct(productId);

        assertThat(updatedProduct.name()).isEqualTo(updateName);
        assertThat(updatedProduct.price()).isEqualTo(updatePrice);
    }
}

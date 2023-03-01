package com.example.tddprac.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setup() {
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
    }

    @Test
    @DisplayName("상품등록 시, 상품명 + 가격 + 할인 정책을 넣어줘야 성공 한다.")
    void 상품등록() {

        final AddProductRequest request = 상품등록요청_생성();

        productService.addProduct(request);

    }

    private AddProductRequest 상품등록요청_생성() {
        final String productName = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(productName, price, discountPolicy);
        return request;
    }

}

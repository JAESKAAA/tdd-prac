package com.example.tddprac.product;

import com.example.tddprac.product.application.port.in.ProductWriteUsecase;
import com.example.tddprac.product.application.service.dto.AddProductRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductWriteServiceTest {

    @Autowired
    ProductWriteUsecase productWriteUsecase;

    @Test
    @DisplayName("상품등록 시, 상품명 + 가격 + 할인 정책을 넣어줘야 성공 한다.")
    void 상품등록() {

        final AddProductRequest request = ProductSteps.상품등록요청_생성();

        productWriteUsecase.addProduct(request);

    }
}

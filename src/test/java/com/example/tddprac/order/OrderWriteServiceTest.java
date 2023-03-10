package com.example.tddprac.order;

import com.example.tddprac.order.application.service.OrderWriteService;
import com.example.tddprac.order.domain.dto.CreateOrderRequest;
import com.example.tddprac.product.ProductSteps;
import com.example.tddprac.product.application.port.in.ProductWriteUsecase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderWriteServiceTest {

    @Autowired
    OrderWriteService orderWriteService;

    @Autowired
    ProductWriteUsecase productWriteUsecase;

    @Test
    @DisplayName("상품 주문 시, Order 가 생성된다.")
    void 상품주문() {
        productWriteUsecase.addProduct(ProductSteps.상품등록요청_생성());

        CreateOrderRequest request = OrderSteps.상품주문요청_생성();

        orderWriteService.createOrder(request);


    }

}

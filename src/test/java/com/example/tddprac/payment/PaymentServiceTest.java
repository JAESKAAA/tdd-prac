package com.example.tddprac.payment;

import com.example.tddprac.order.application.service.OrderWriteService;
import com.example.tddprac.order.OrderSteps;
import com.example.tddprac.payment.application.port.in.PaymentWriteUsecase;
import com.example.tddprac.payment.domain.dto.PaymentRequest;
import com.example.tddprac.product.application.port.in.ProductWriteUsecase;
import com.example.tddprac.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentServiceTest {

    @Autowired
    PaymentWriteUsecase paymentWriteUsecase;

    @Autowired
    ProductWriteUsecase productWriteUsecase;

    @Autowired
    OrderWriteService orderWriteService;

    @Test
    void 상품주문() {
        productWriteUsecase.addProduct(ProductSteps.상품등록요청_생성());
        orderWriteService.createOrder(OrderSteps.상품주문요청_생성());
        PaymentRequest request = PaymentSteps.주문결제요청_생성();
        paymentWriteUsecase.payment(request);
    }

}

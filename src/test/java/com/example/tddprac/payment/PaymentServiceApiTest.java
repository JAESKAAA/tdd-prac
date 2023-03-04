package com.example.tddprac.payment;

import com.example.tddprac.ApiTest;
import com.example.tddprac.order.OrderSteps;
import com.example.tddprac.product.ProductSteps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class PaymentServiceApiTest extends ApiTest {

    @Test
    void 상품결제_API() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성());

        final var request  = PaymentSteps.주문결제요청_생성();
        final var response = PaymentSteps.주문결제요청(request);

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}

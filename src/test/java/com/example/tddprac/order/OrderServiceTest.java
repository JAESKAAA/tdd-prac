package com.example.tddprac.order;

import com.example.tddprac.product.ProductService;
import com.example.tddprac.product.ProductSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Test
    @DisplayName("상품 주문 시, Order 가 생성된다.")
    void 상품주문() {
        productService.addProduct(ProductSteps.상품등록요청_생성());

        CreateOrderRequest request = OrderSteps.상품주문요청_생성();

        orderService.createOrder(request);
    }

}

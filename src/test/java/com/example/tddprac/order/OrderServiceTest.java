package com.example.tddprac.order;

import com.example.tddprac.product.DiscountPolicy;
import com.example.tddprac.product.Product;
import com.example.tddprac.product.ProductRepository;
import com.example.tddprac.product.ProductService;
import com.example.tddprac.product.ProductSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Test
    @DisplayName("상품 주문시 orderId 반환된다.")
    void 상품주문() {

        productService.addProduct(ProductSteps.상품등록요청_생성());
        CreateOrderRequest request = 상품주문요청_생성();

        orderService.createOrder(request);
    }

    private static CreateOrderRequest 상품주문요청_생성() {
        final Long productId = 1L;
        final int quantity = 20;
        return new CreateOrderRequest(productId, quantity);
    }
}

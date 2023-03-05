package com.example.tddprac.order;

import com.example.tddprac.product.application.port.out.ReadProductJpaPort;
import com.example.tddprac.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderPort orderPort;
    private final ReadProductJpaPort readProductPort;

    @Transactional
    public Long createOrder(CreateOrderRequest request) {
        Product product = readProductPort.getProduct(request.productId());

        Order order = new Order(product, request.quantity());

        orderPort.save(order);

        return order.getId();
    }
}

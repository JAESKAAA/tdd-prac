package com.example.tddprac.order;

import com.example.tddprac.product.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public
class OrderService {

    private final OrderPort orderPort;

    public OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }


    @Transactional
    public Long createOrder(CreateOrderRequest request) {
        Product product = orderPort.getProductById(request.productId());

        Order order = new Order(product, request.quantity());

        orderPort.save(order);

        return order.getId();
    }
}

package com.example.tddprac.order.application.service;

import com.example.tddprac.order.domain.dto.CreateOrderRequest;
import com.example.tddprac.order.domain.Order;
import com.example.tddprac.order.application.port.in.OrderWriteUsecase;
import com.example.tddprac.order.application.port.out.WriteOrderJpaPort;
import com.example.tddprac.product.application.port.out.ReadProductJpaPort;
import com.example.tddprac.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderWriteService implements OrderWriteUsecase {

    private final WriteOrderJpaPort writeOrderJpaPort;
    private final ReadProductJpaPort readProductPort;

    @Override
    @Transactional
    public Long createOrder(CreateOrderRequest request) {
        Product product = readProductPort.getProduct(request.productId());

        Order order = new Order(product, request.quantity());

        writeOrderJpaPort.save(order);

        return order.getId();
    }
}

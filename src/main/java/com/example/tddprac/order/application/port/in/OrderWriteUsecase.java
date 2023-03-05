package com.example.tddprac.order.application.port.in;

import com.example.tddprac.order.domain.dto.CreateOrderRequest;

public interface OrderWriteUsecase {

    Long createOrder(CreateOrderRequest request);
}

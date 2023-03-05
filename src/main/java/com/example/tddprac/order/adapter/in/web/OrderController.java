package com.example.tddprac.order.adapter.in.web;

import com.example.tddprac.order.domain.dto.CreateOrderRequest;
import com.example.tddprac.order.application.port.in.OrderWriteUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderWriteUsecase orderWriteUsecase;

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderRequest request) {
        orderWriteUsecase.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

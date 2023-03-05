package com.example.tddprac.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class OrderAdapter implements OrderPort {

    private final OrderRepository orderRepository;


    @Override
    public void save(Order order) {
        OrderEntity orderEntity = OrderEntityMapper.INSTANCE.toEntity(order);

        orderRepository.save(orderEntity);
    }

    @Override
    public Order getOrder(Long orderId) {

        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("해당 주문을 찾을 수 없습니다."));

        return OrderEntityMapper.INSTANCE.toModel(orderEntity);
    }
}

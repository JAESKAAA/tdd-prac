package com.example.tddprac.order.adapter.out.persistence;

import com.example.tddprac.order.domain.Order;
import com.example.tddprac.order.application.port.out.ReadOrderJpaPort;
import com.example.tddprac.order.adapter.out.persistence.mapper.OrderEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ReadOrderJpaAdapter implements ReadOrderJpaPort {

    private final OrderRepository orderRepository;



    @Override
    public Order getOrder(Long orderId) {

        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("해당 주문을 찾을 수 없습니다."));

        return OrderEntityMapper.INSTANCE.toModel(orderEntity);
    }
}

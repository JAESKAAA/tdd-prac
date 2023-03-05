package com.example.tddprac.order.adapter.out.persistence;

import com.example.tddprac.order.domain.Order;
import com.example.tddprac.order.application.port.out.WriteOrderJpaPort;
import com.example.tddprac.order.adapter.out.persistence.mapper.OrderEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class WriteOrderJpaAdapter implements WriteOrderJpaPort {

    private final OrderRepository orderRepository;


    @Override
    public void save(Order order) {
        OrderEntity orderEntity = OrderEntityMapper.INSTANCE.toEntity(order);

        orderRepository.save(orderEntity);
    }
}

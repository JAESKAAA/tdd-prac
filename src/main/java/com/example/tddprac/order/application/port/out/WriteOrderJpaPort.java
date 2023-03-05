package com.example.tddprac.order.application.port.out;

import com.example.tddprac.order.domain.Order;

public interface WriteOrderJpaPort {

    void save(Order order);


}

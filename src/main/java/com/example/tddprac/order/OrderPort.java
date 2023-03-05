package com.example.tddprac.order;

public interface OrderPort {

    void save(Order order);

    Order getOrder(Long orderId);


}

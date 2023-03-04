package com.example.tddprac.payment;

import com.example.tddprac.order.Order;

interface PaymentPort {

    Order getOrder(Long orderId);

    void save(Payment payment);

    void pay(int price, String cardNumber);

}

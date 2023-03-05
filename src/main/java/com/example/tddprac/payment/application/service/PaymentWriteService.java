package com.example.tddprac.payment.application.service;

import com.example.tddprac.order.Order;
import com.example.tddprac.order.OrderPort;
import com.example.tddprac.payment.application.port.out.PaymentPort;
import com.example.tddprac.payment.domain.dto.PaymentRequest;
import com.example.tddprac.payment.application.port.in.PaymentWriteUsecase;
import com.example.tddprac.payment.application.port.out.WritePaymentJpaPort;
import com.example.tddprac.payment.domain.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class PaymentWriteService implements PaymentWriteUsecase {

    private final OrderPort orderPort;
    private final PaymentPort paymentPort;
    private final WritePaymentJpaPort writePaymentJpaPort;


    @Transactional
    @Override
    public void payment(PaymentRequest request) {

        final Order order = orderPort.getOrder(request.orderId());

        final Payment payment = new Payment(order, request.cardNumber());

        paymentPort.pay(payment.getPrice(), payment.getCardNumber());

        writePaymentJpaPort.save(payment);
    }
}

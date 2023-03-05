package com.example.tddprac.payment.adapter.out.persistence;

import com.example.tddprac.payment.adapter.out.payment.PaymentGateway;
import com.example.tddprac.payment.adapter.out.persistence.mapper.PaymentEntityMapper;
import com.example.tddprac.payment.application.port.out.WritePaymentJpaPort;
import com.example.tddprac.payment.domain.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentWriteJpaAdapter implements WritePaymentJpaPort {
    private final PaymentRepository paymentRepository;
    private final PaymentGateway paymentGateway;

    @Override
    public void save(Payment payment) {
        PaymentEntity paymentEntity = PaymentEntityMapper.INSTANCE.toEntity(payment);

        paymentRepository.save(paymentEntity);
    }
}

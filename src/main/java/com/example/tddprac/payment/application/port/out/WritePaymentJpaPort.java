package com.example.tddprac.payment.application.port.out;

import com.example.tddprac.payment.domain.Payment;

public interface WritePaymentJpaPort {

    void save(Payment payment);


}

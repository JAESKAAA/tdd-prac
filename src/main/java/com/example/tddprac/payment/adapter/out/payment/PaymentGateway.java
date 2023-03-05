package com.example.tddprac.payment.adapter.out.payment;

public interface PaymentGateway {

    void execute(int price, String cardNumber);

}

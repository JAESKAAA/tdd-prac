package com.example.tddprac.payment;

interface PaymentGateway {

    void execute(int price, String cardNumber);

}

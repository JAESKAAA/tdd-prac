package com.example.tddprac.payment.domain;

import com.example.tddprac.order.domain.Order;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class Payment {

    private Long id;
    private Order order;
    private String cardNumber;

    public Payment(Order order, String cardNumber) {
        Assert.notNull(order, "주문은 필수입니다.");
        Assert.hasText(cardNumber, "카드번호는 필수입니다.");
        this.order = order;
        this.cardNumber = cardNumber;
    }

    public Long getId() {
        return id;
    }

    public int getPrice() {
       return order.getTotalPrice();
    }
}

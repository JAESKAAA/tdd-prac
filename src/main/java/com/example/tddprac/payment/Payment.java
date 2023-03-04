package com.example.tddprac.payment;

import com.example.tddprac.order.Order;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
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

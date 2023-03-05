package com.example.tddprac.order;

import com.example.tddprac.product.adapter.out.persistence.ProductEntity;
import com.example.tddprac.product.domain.Product;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private ProductEntity product;

    private int quantity;

    public OrderEntity(ProductEntity productEntity, int quantity) {
        this.product = productEntity;
        this.quantity = quantity;
    }
}

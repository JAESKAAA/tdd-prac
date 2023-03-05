package com.example.tddprac.product.application.port.out;

import com.example.tddprac.product.adapter.out.persistence.ProductEntity;
import com.example.tddprac.product.domain.Product;

public interface ReadProductJpaPort {

    Product getProduct(Long productId);

    ProductEntity getProductEntity(Long productId);

}

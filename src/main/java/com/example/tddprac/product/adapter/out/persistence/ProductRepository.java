package com.example.tddprac.product.adapter.out.persistence;

import com.example.tddprac.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

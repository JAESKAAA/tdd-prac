package com.example.tddprac.product;

import java.util.HashMap;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface ProductRepository extends JpaRepository<Product, Long> {
}

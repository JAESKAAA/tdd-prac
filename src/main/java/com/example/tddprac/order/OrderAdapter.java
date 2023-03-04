package com.example.tddprac.order;

import com.example.tddprac.product.Product;
import com.example.tddprac.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
class OrderAdapter implements OrderPort {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderAdapter(ProductRepository productRepository,
        OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
            .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}

package com.example.tddprac.product;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setup() {
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
    }

    @Test
    @DisplayName("상품등록 시, 상품명 + 가격 + 할인 정책을 넣어줘야 성공 한다.")
    void 상품등록() {

        final String productName = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(productName, price, discountPolicy);

        productService.addProduct(request);

    }

    private record AddProductRequest(String productName, int price, DiscountPolicy discountPolicy) {
        private AddProductRequest {
            Assert.hasText(productName, "상품명은 필수입니다.");
            Assert.isTrue(price > 0, "상품가격은 0보다 커야합니다.");
            Assert.notNull(discountPolicy, "할인정책은 필수 입니다.");
        }
    }

    private enum DiscountPolicy {
        NONE

    }

    private class ProductService {
        private final ProductPort productPort;

        private ProductService(ProductPort productPort) {
            this.productPort = productPort;
        }

        public void addProduct(AddProductRequest request) {
            final Product product = new Product(request.productName, request.price, request.discountPolicy);

            productPort.save(product);
        }
    }

    private class Product {

        private Long id;
        private final String productName;
        private final int price;
        private final DiscountPolicy discountPolicy;

        public Product(String productName, int price, DiscountPolicy discountPolicy) {
            Assert.hasText(productName, "상품명은 필수입니다.");
            Assert.isTrue(price > 0, "상품가격은 0보다 커야합니다.");
            Assert.notNull(discountPolicy, "할인정책은 필수 입니다.");
            this.productName = productName;
            this.price = price;
            this.discountPolicy = discountPolicy;
        }

        public void assignId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

    private interface ProductPort {
        void save(Product product);
    }

    private class ProductAdapter implements ProductPort {

        private final ProductRepository productRepository;

        private ProductAdapter(
            ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @Override
        public void save(Product product) {
            productRepository.save(product);
        }
    }

    private class ProductRepository {
        private Long sequence = 0L;
        private Map<Long, Product> persistence = new HashMap<>();
        


        public void save(Product product) {
            product.assignId(++sequence);
            persistence.put(product.getId(), product);
        }
    }
}

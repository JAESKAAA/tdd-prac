package com.example.tddprac.product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class ProductService {

    private final ProductPort productPort;

    ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    @Transactional
    public void addProduct(final AddProductRequest request) {
        final Product product = new Product(request.productName(), request.price(), request.discountPolicy());

        productPort.save(product);
    }

    public GetProductResponse getProduct(final Long productId) {
       final Product product = productPort.getProduct(productId);

        return new GetProductResponse(product.getId(), product.getProductName(), product.getPrice(),
            product.getDiscountPolicy());




    }
}

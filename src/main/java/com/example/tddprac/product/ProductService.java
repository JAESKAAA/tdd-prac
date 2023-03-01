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
    public Long addProduct(final AddProductRequest request) {
        final Product product = new Product(request.productName(), request.price(), request.discountPolicy());

        productPort.save(product);
        return product.getId();
    }

    @Transactional(readOnly = true)
    public GetProductResponse getProduct(final Long productId) {
       final Product product = productPort.getProduct(productId);

        return new GetProductResponse(product.getId(), product.getProductName(), product.getPrice(),
            product.getDiscountPolicy());
    }

    @Transactional
    public void updateProduct(Long productId, UpdateProductRequest request) {
        Product product = productPort.getProduct(productId);
        product.update(request.productName(), request.price(), request.discountPolicy());
    }
}

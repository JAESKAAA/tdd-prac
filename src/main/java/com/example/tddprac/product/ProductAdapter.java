package com.example.tddprac.product;

class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    ProductAdapter(
        ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}

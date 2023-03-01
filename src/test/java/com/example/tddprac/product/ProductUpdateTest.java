package com.example.tddprac.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductUpdateTest {

    private ProductService productService;

//    private StubProductPort productPort = new StubProductPort();
    private ProductPort productPort;

    @BeforeEach
    void setup() {
        productPort = Mockito.mock(ProductPort.class);

        productService = new ProductService(productPort);
    }


    @Test
    @DisplayName("상품 수정 성공 시, 수정된 이름으로 변경된다.")
    void 상품수정() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        final Long productId = product.getId();

        final String updateName = "상품 수정";
        int updatePrice = 20000;
        final UpdateProductRequest request = new UpdateProductRequest(updateName, updatePrice, DiscountPolicy.NONE);
        Mockito.when(productPort.getProduct(productId)).thenReturn(product);

        productService.updateProduct(productId, request);

        assertThat(product.getProductName()).isEqualTo(updateName);
        assertThat(product.getPrice()).isEqualTo(updatePrice);
    }

//    private static class StubProductPort implements ProductPort {
//
//        public Product get_product_will_return;
//
//        @Override
//        public void save(Product product) {
//
//        }
//
//        @Override
//        public Product getProduct(Long productId) {
//            return get_product_will_return;
//        }
//    }


}

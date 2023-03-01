package com.example.tddprac.product;

import static org.assertj.core.api.Assertions.*;

import com.example.tddprac.ApiTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ProductApiTest extends ApiTest {


    private final ProductSteps productSteps = new ProductSteps();

    @Test
    @DisplayName("상품등록에 성공하면 201 코드를 반환한다.")
    void 상품등록_API() {

        final var request = productSteps.상품등록요청_생성();

        final var response = productSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    @DisplayName("상품 조회에 성공하면 요청한 Id값을 가져온다.")
    void 상품조회_API() {
        ExtractableResponse<Response> 상품등록요청 = ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());

        Long productId = 1L;

        ExtractableResponse<Response> response = ProductSteps.상품조회요청(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }


}

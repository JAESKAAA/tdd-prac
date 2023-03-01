package com.example.tddprac.product;

import static org.assertj.core.api.Assertions.*;

import com.example.tddprac.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class ProductApiTest extends ApiTest {


    @Test
    @DisplayName("상품등록에 성공하면 201 코드를 반환한다.")
    void 상품등록_API() {

        final var request = 상품등록요청_생성();

        final var response = 상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private ExtractableResponse<Response> 상품등록요청(AddProductRequest request) {
        return RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .post("/products")
            .then()
            .log().all().extract();
    }

    private AddProductRequest 상품등록요청_생성() {
        final String productName = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(productName, price, discountPolicy);
        return request;
    }

}

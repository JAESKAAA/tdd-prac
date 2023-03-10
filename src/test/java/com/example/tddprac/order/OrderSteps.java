package com.example.tddprac.order;

import com.example.tddprac.order.domain.dto.CreateOrderRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class OrderSteps {

    public static CreateOrderRequest 상품주문요청_생성() {
        final Long productId = 1L;
        final int quantity = 20;
        return new CreateOrderRequest(productId, quantity);
    }

    public static ExtractableResponse<Response> 상품주문요청(CreateOrderRequest request) {
        return RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .post("/orders")
            .then().log().all().extract();
    }
}

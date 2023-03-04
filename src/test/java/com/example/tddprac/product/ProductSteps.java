package com.example.tddprac.product;

import com.example.tddprac.product.application.service.dto.AddProductRequest;
import com.example.tddprac.product.application.service.dto.UpdateProductRequest;
import com.example.tddprac.product.domain.DiscountPolicy;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class ProductSteps {


    public static ExtractableResponse<Response> 상품등록요청(AddProductRequest request) {
        return RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .post("/products")
            .then()
            .log().all().extract();
    }

    public static AddProductRequest 상품등록요청_생성() {
        final String productName = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        return new AddProductRequest(productName, price, discountPolicy);
    }

    public static ExtractableResponse<Response> 상품조회요청(Long productId) {
        return RestAssured.given().log().all()
            .when()
            .get("/products/{productId}", productId)
            .then().log().all()
            .extract();
    }

    public static UpdateProductRequest 상품수정요청() {
        final String updateName = "상품 수정";
        int updatePrice = 20000;
        return new UpdateProductRequest(updateName, updatePrice, DiscountPolicy.NONE);
    }
}
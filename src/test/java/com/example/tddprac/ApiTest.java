package com.example.tddprac;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //랜덤포트 사용
public class ApiTest {

    @LocalServerPort //설정된 랜덤포트를 바인딩 시켜줌
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
    }

}

package com.example.ci_demo.presentationlayer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class ControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void TestHello() {
        webTestClient.get().uri("/api/v1/ci_demo/hello")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello, World!");
    }

    @Test
    public void TestTheVariableEndpoint_ShouldSucceed() {
        webTestClient.get().uri("/api/v1/ci_demo/variable")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("variable");
    }
    @Test
    public void TestTheVariableEndpoint_ShouldFail() {
        webTestClient.get().uri("/api/v1/ci_demo/testtest")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("testtest");
    }
}
package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.SocatContainer;

import static org.hamcrest.Matchers.equalTo;

public class LlmRunnerTest {
    
    @Test
    void test() {
        try (SocatContainer socat = new SocatContainer()
                .withTarget(80, "model-runner.docker.internal", 80)) {
            socat.start();
            Integer llmRunnerPort = socat.getMappedPort(80);
            
            RestAssured.baseURI = "http://%s:%d".formatted(socat.getHost(), llmRunnerPort);

            RestAssured.get("/models")
                    .prettyPeek()
                    .then()
                    .statusCode(200);
            
            RestAssured.given()
                    .body("""
                            {
                                "from": "ignaciolopezluna020/llama3.2:1b"
                            }
                            """)
                    .post("/models/create")
                    .prettyPeek()
                    .then()
                    .statusCode(200);

            RestAssured.get("/models")
                    .prettyPeek()
                    .then()
                    .statusCode(200)
                    .assertThat()
                    .body("size()", equalTo(1));
            
            RestAssured.delete("/models/ignaciolopezluna020/llama3.2:1b")
                    .prettyPeek()
                    .then()
                    .statusCode(200);

            RestAssured.get("/models")
                    .prettyPeek()
                    .then()
                    .statusCode(200)
                    .assertThat()
                    .body("size()", equalTo(0));
        }
    }
    
}

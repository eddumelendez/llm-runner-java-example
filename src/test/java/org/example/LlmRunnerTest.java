package org.example;

import com.docker.llmrunner.api.LlmRunnerClient;
import com.docker.llmrunner.api.models.Model;
import com.docker.llmrunner.api.models.ModelList;
import com.docker.llmrunner.api.models.ModelListData;
import com.docker.llmrunner.api.modelsrequests.create.CreatePostRequestBody;
import com.microsoft.kiota.authentication.AnonymousAuthenticationProvider;
import com.microsoft.kiota.bundle.DefaultRequestAdapter;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.SocatContainer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;

public class LlmRunnerTest {
    
    @Test
    void test() throws IOException {
        try (SocatContainer socat = new SocatContainer()
                .withTarget(80, "model-runner.docker.internal", 80)) {
            socat.start();
            Integer llmRunnerPort = socat.getMappedPort(80);
            String baseUri = "http://%s:%d".formatted(socat.getHost(), llmRunnerPort);
            RestAssured.baseURI = baseUri;

            DefaultRequestAdapter requestAdapter = new DefaultRequestAdapter(new AnonymousAuthenticationProvider());
            requestAdapter.setBaseUrl(baseUri);
            LlmRunnerClient client = new LlmRunnerClient(requestAdapter);

            RestAssured.get("/")
                    .prettyPeek()
                    .then()
                    .statusCode(200)
                    .assertThat()
                    .body(containsString("The service is running."));

            assertThat(client.models().get()).hasSize(0);

            CreatePostRequestBody createPostRequestBody = new CreatePostRequestBody();
            createPostRequestBody.setFrom("ignaciolopezluna020/llama3.2:1b");
            InputStream post = client.models().create().post(createPostRequestBody);
            post.readAllBytes();

            assertThat(client.models().get()).hasSize(1);

            Model model = client.models().byNamespace("ignaciolopezluna020").byName("llama3.2:1b").get();
            assertThat(model.getTags()).hasSize(1);
            assertThat(model.getTags()).contains("ignaciolopezluna020/llama3.2:1b");

            ModelList models = client.engines().v1().models().get();
            List<ModelListData> data = models.getData();
            assertThat(data.get(0).getId()).isEqualTo("ignaciolopezluna020/llama3.2:1b");
            assertThat(data.get(0).getObject()).isEqualTo("model");
            
            client.models().byNamespace("ignaciolopezluna020").byName("llama3.2:1b").delete();

            assertThat(client.models().get()).hasSize(0);
            
        }
    }
    
}

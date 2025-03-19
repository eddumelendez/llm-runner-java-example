package com.docker.llmrunner.api;

import com.docker.llmrunner.api.engines.EnginesRequestBuilder;
import com.docker.llmrunner.api.modelsrequests.ModelsRequestBuilder;
import com.microsoft.kiota.ApiClientBuilder;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import com.microsoft.kiota.serialization.ParseNodeFactoryRegistry;
import com.microsoft.kiota.serialization.SerializationWriterFactoryRegistry;
import java.util.HashMap;
import java.util.Objects;
/**
 * The main entry point of the SDK, exposes the configuration and the fluent API.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class LlmRunnerClient extends BaseRequestBuilder {
    /**
     * The engines property
     * @return a {@link EnginesRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public EnginesRequestBuilder engines() {
        return new EnginesRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The models property
     * @return a {@link ModelsRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public ModelsRequestBuilder models() {
        return new ModelsRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Instantiates a new {@link LlmRunnerClient} and sets the default values.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public LlmRunnerClient(@jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}");
        this.pathParameters = new HashMap<>();
    }
}

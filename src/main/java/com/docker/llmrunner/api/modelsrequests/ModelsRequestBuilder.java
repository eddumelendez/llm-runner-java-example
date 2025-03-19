package com.docker.llmrunner.api.modelsrequests;

import com.docker.llmrunner.api.modelsrequests.create.CreateRequestBuilder;
import com.docker.llmrunner.api.modelsrequests.item.WithNamespaceItemRequestBuilder;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.BaseRequestConfiguration;
import com.microsoft.kiota.HttpMethod;
import com.microsoft.kiota.RequestAdapter;
import com.microsoft.kiota.RequestInformation;
import com.microsoft.kiota.RequestOption;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParsableFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * Builds and executes requests for operations under /models
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class ModelsRequestBuilder extends BaseRequestBuilder {
    /**
     * The create property
     * @return a {@link CreateRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public CreateRequestBuilder create() {
        return new CreateRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Gets an item from the com.docker.llmrunner.api.modelsRequests.item collection
     * @param namespace Unique identifier of the item
     * @return a {@link WithNamespaceItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithNamespaceItemRequestBuilder byNamespace(@jakarta.annotation.Nonnull final String namespace) {
        Objects.requireNonNull(namespace);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("namespace", namespace);
        return new WithNamespaceItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link ModelsRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public ModelsRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/models", pathParameters);
    }
    /**
     * Instantiates a new {@link ModelsRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public ModelsRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/models", rawUrl);
    }
    /**
     * List all models
     * @return a {@link java.util.List<Models>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<Models> get() {
        return get(null);
    }
    /**
     * List all models
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link java.util.List<Models>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<Models> get(@jakarta.annotation.Nullable final java.util.function.Consumer<GetRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = toGetRequestInformation(requestConfiguration);
        return this.requestAdapter.sendCollection(requestInfo, null, Models::createFromDiscriminatorValue);
    }
    /**
     * List all models
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toGetRequestInformation() {
        return toGetRequestInformation(null);
    }
    /**
     * List all models
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toGetRequestInformation(@jakarta.annotation.Nullable final java.util.function.Consumer<GetRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = new RequestInformation(HttpMethod.GET, urlTemplate, pathParameters);
        requestInfo.configure(requestConfiguration, GetRequestConfiguration::new);
        requestInfo.headers.tryAdd("Accept", "application/json");
        return requestInfo;
    }
    /**
     * Returns a request builder with the provided arbitrary URL. Using this method means any other path or query parameters are ignored.
     * @param rawUrl The raw URL to use for the request builder.
     * @return a {@link ModelsRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public ModelsRequestBuilder withUrl(@jakarta.annotation.Nonnull final String rawUrl) {
        Objects.requireNonNull(rawUrl);
        return new ModelsRequestBuilder(rawUrl, requestAdapter);
    }
    /**
     * Configuration for the request such as headers, query parameters, and middleware options.
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public class GetRequestConfiguration extends BaseRequestConfiguration {
    }
}

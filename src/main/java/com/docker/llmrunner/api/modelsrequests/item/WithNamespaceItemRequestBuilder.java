package com.docker.llmrunner.api.modelsrequests.item;

import com.docker.llmrunner.api.modelsrequests.item.item.WithNameItemRequestBuilder;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
/**
 * Builds and executes requests for operations under /models/{namespace}
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class WithNamespaceItemRequestBuilder extends BaseRequestBuilder {
    /**
     * Gets an item from the com.docker.llmrunner.api.modelsRequests.item.item collection
     * @param name Unique identifier of the item
     * @return a {@link WithNameItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithNameItemRequestBuilder byName(@jakarta.annotation.Nonnull final String name) {
        Objects.requireNonNull(name);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("name", name);
        return new WithNameItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link WithNamespaceItemRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public WithNamespaceItemRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/models/{namespace}", pathParameters);
    }
    /**
     * Instantiates a new {@link WithNamespaceItemRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public WithNamespaceItemRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/models/{namespace}", rawUrl);
    }
}

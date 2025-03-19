package com.docker.llmrunner.api.engines.v1.modelsrequests;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class ModelsGetResponseData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The created property
     */
    private Long created;
    /**
     * The id property
     */
    private String id;
    /**
     * The object property
     */
    private String objectEscaped;
    /**
     * The owned_by property
     */
    private String ownedBy;
    /**
     * Instantiates a new {@link ModelsGetResponseData} and sets the default values.
     */
    public ModelsGetResponseData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link ModelsGetResponseData}
     */
    @jakarta.annotation.Nonnull
    public static ModelsGetResponseData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new ModelsGetResponseData();
    }
    /**
     * Gets the AdditionalData property value. Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     * @return a {@link Map<String, Object>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, Object> getAdditionalData() {
        return this.additionalData;
    }
    /**
     * Gets the created property value. The created property
     * @return a {@link Long}
     */
    @jakarta.annotation.Nullable
    public Long getCreated() {
        return this.created;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(4);
        deserializerMap.put("created", (n) -> { this.setCreated(n.getLongValue()); });
        deserializerMap.put("id", (n) -> { this.setId(n.getStringValue()); });
        deserializerMap.put("object", (n) -> { this.setObject(n.getStringValue()); });
        deserializerMap.put("owned_by", (n) -> { this.setOwnedBy(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the id property value. The id property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getId() {
        return this.id;
    }
    /**
     * Gets the object property value. The object property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getObject() {
        return this.objectEscaped;
    }
    /**
     * Gets the owned_by property value. The owned_by property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getOwnedBy() {
        return this.ownedBy;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeLongValue("created", this.getCreated());
        writer.writeStringValue("id", this.getId());
        writer.writeStringValue("object", this.getObject());
        writer.writeStringValue("owned_by", this.getOwnedBy());
        writer.writeAdditionalData(this.getAdditionalData());
    }
    /**
     * Sets the AdditionalData property value. Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     * @param value Value to set for the AdditionalData property.
     */
    public void setAdditionalData(@jakarta.annotation.Nullable final Map<String, Object> value) {
        this.additionalData = value;
    }
    /**
     * Sets the created property value. The created property
     * @param value Value to set for the created property.
     */
    public void setCreated(@jakarta.annotation.Nullable final Long value) {
        this.created = value;
    }
    /**
     * Sets the id property value. The id property
     * @param value Value to set for the id property.
     */
    public void setId(@jakarta.annotation.Nullable final String value) {
        this.id = value;
    }
    /**
     * Sets the object property value. The object property
     * @param value Value to set for the object property.
     */
    public void setObject(@jakarta.annotation.Nullable final String value) {
        this.objectEscaped = value;
    }
    /**
     * Sets the owned_by property value. The owned_by property
     * @param value Value to set for the owned_by property.
     */
    public void setOwnedBy(@jakarta.annotation.Nullable final String value) {
        this.ownedBy = value;
    }
}

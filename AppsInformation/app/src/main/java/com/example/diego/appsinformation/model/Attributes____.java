package com.example.diego.appsinformation.model;

/**
 * Created by Diego on 24/06/2016.
 */
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Attributes____ {
    @SerializedName("im:id")
    private String imId;
    private String imBundleId;

    /**
     * @return The imId
     */
    public String getImId() {
        return imId;
    }

    /**
     * @param imId The im:id
     */
    public void setImId(String imId) {
        this.imId = imId;
    }

    /**
     * @return The imBundleId
     */
    public String getImBundleId() {
        return imBundleId;
    }

    /**
     * @param imBundleId The im:bundleId
     */
    public void setImBundleId(String imBundleId) {
        this.imBundleId = imBundleId;
    }
}

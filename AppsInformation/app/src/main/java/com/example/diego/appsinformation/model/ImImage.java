package com.example.diego.appsinformation.model;

/**
 * Created by Diego on 24/06/2016.
 */
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ImImage {
    private String label;
    private Attributes attributes;

    /**
     * @return The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return The attributes
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * @param attributes The attributes
     */
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}

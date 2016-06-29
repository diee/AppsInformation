package com.example.diego.appsinformation.model;

/**
 * Created by Diego on 24/06/2016.
 */
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Author {
    private Name name;
    private Uri uri;

    /**
     * @return The name
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * @return The uri
     */
    public Uri getUri() {
        return uri;
    }

    /**
     * @param uri The uri
     */
    public void setUri(Uri uri) {
        this.uri = uri;
    }
}

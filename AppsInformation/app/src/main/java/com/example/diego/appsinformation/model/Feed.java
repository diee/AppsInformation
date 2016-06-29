package com.example.diego.appsinformation.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego on 24/06/2016.
 */
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Feed {
    private Author author;
    private ArrayList<Entry> entry = new ArrayList<Entry>();
    private Updated updated;
    private Rights_ rights;
    private Title_ title;
    private Icon icon;
    private List<Link_> link = new ArrayList<Link_>();
    private Id_ id;

    /**
     * @return The author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * @param author The author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @return The entry
     */
    public ArrayList<Entry> getEntry() {
        return entry;
    }

    /**
     * @param entry The entry
     */
    public void setEntry(ArrayList<Entry> entry) {
        this.entry = entry;
    }

    /**
     * @return The updated
     */
    public Updated getUpdated() {
        return updated;
    }

    /**
     * @param updated The updated
     */
    public void setUpdated(Updated updated) {
        this.updated = updated;
    }

    /**
     * @return The rights
     */
    public Rights_ getRights() {
        return rights;
    }

    /**
     * @param rights The rights
     */
    public void setRights(Rights_ rights) {
        this.rights = rights;
    }

    /**
     * @return The title
     */
    public Title_ getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(Title_ title) {
        this.title = title;
    }

    /**
     * @return The icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * @param icon The icon
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * @return The link
     */
    public List<Link_> getLink() {
        return link;
    }

    /**
     * @param link The link
     */
    public void setLink(List<Link_> link) {
        this.link = link;
    }

    /**
     * @return The id
     */
    public Id_ getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Id_ id) {
        this.id = id;
    }
}

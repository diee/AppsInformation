package com.example.diego.appsinformation.model;

import com.orm.SugarRecord;

/**
 * Created by Diego on 26/06/2016.
 */
public class Application extends SugarRecord {
    Long id;
    String name;
    String img53;
    String img75;
    String img100;
    String summary;
    String price;
    String title;
    String artist;
    String category;
    String release;

    public Application(){}

    public Application(Long id, String name, String img53, String img75, String img100, String summary, String price, String title, String artist, String category, String release) {
        this.id = id;
        this.name = name;
        this.img53 = img53;
        this.img75 = img75;
        this.img100 = img100;
        this.summary = summary;
        this.price = price;
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.release = release;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg53() {
        return img53;
    }

    public void setImg53(String img53) {
        this.img53 = img53;
    }

    public String getImg75() {
        return img75;
    }

    public void setImg75(String img75) {
        this.img75 = img75;
    }

    public String getImg100() {
        return img100;
    }

    public void setImg100(String img100) {
        this.img100 = img100;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }
}

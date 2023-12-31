package com.gamescore.domain;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Videogame {

    //Atributos
    private ObjectId _id;
    private String name;
    private String description [];
    private double price;
    private String video;

    private String categories [];
    private String stores [];
    private String images [];

    private ArrayList<Review> reviews;

    public Videogame() {
    }

    public Videogame(ObjectId _id) {
        this._id = _id;
    }

    public Videogame(String name) {
        this.name = name;
    }

    public Videogame(String name, String description [], double price, String video, String[] categories, String[] stores, String[] images) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.video = video;
        this.categories = categories;
        this.stores = stores;
        this.images = images;
    }

    public Videogame(ObjectId _id, String name, String description [], double price, String video, String[] categories, String[] stores, String[] images) {
        this._id = _id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.video = video;
        this.categories = categories;
        this.stores = stores;
        this.images = images;
    }

    @Override
    public String toString() {
        return "Videogame{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", video='" + video + '\'' +
                '}';
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String [] getDescription() {
        return description;
    }

    public void setDescription(String description []) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String[] getStores() {
        return stores;
    }

    public void setStores(String[] stores) {
        this.stores = stores;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Videogame videogame = (Videogame) o;
        return Double.compare(price, videogame.price) == 0 && Objects.equals(_id, videogame._id) && Objects.equals(name, videogame.name) && Arrays.equals(description, videogame.description) && Objects.equals(video, videogame.video) && Arrays.equals(categories, videogame.categories) && Arrays.equals(stores, videogame.stores) && Arrays.equals(images, videogame.images) && Objects.equals(reviews, videogame.reviews);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(_id, name, price, video, reviews);
        result = 31 * result + Arrays.hashCode(description);
        result = 31 * result + Arrays.hashCode(categories);
        result = 31 * result + Arrays.hashCode(stores);
        result = 31 * result + Arrays.hashCode(images);
        return result;
    }
}

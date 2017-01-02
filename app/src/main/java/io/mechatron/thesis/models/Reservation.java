package io.mechatron.thesis.models;

/**
 * Created by migz on 1/2/17.
 */

public class Reservation {

    public Reservation(String imageUrl, String name, double price, int reviews) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
        this.reviews = reviews;
    }

    public String imageUrl;
    public String name;
    public double price;
    public int reviews;

}

package com.example.a121firstapp.Class_item;

public class Item_in_pending {

    private int image_view;
    private String brand,post_on,renew_on;
    private double price;

    public Item_in_pending(int image_view, String brand, String post_on, String renew_on, double price) {
        this.image_view = image_view;
        this.brand = brand;
        this.post_on = post_on;
        this.renew_on = renew_on;
        this.price = price;
    }

    public int getImage_view() {
        return image_view;
    }

    public String getBrand() {
        return brand;
    }

    public String getPost_on() {
        return post_on;
    }

    public String getRenew_on() {
        return renew_on;
    }

    public double getPrice() {
        return price;
    }

    public void setImage_view(int image_view) {
        this.image_view = image_view;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPost_on(String post_on) {
        this.post_on = post_on;
    }

    public void setRenew_on(String renew_on) {
        this.renew_on = renew_on;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

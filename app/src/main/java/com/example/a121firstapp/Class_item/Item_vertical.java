package com.example.a121firstapp.Class_item;

public class Item_vertical {
    private int image_view;
    private String brand;
    private double price;
    private double dic;
    private String location;

    public Item_vertical(int image_view, String brand, double price) {
        this.image_view = image_view;
        this.brand = brand;
        this.price = price;
        this.location=location;
    }

    public int getImage_view() {
        return image_view;
    }
    public String getBrand() {
        return brand;
    }
    public double getPrice() {
        return price;
    }
    public String getLocation(){return location;}
    public void setImage_view(int image_view) {
        this.image_view = image_view;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setLocation(String location){this.location=location;}
}

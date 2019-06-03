package com.example.a121firstapp.Class_item;

import java.io.Serializable;

public class Item_horizotal implements Serializable {
    private int image_view;
    private String brand;
    private double price;
    private double dic;

    public Item_horizotal(int image_view, String brand, double price, double dic) {
        this.image_view = image_view;
        this.brand = brand;
        this.price = price;
        this.dic = dic;
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

    public double getDic() {
        return dic;
    }

    public void setImage_view(int image_view) {
        this.image_view = image_view;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDic(double dic) {
        this.dic = dic;
    }
}

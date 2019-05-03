package com.example.a121firstapp.Class_item;

public class Item_in_loan {

    private int image_view;
    private String brand;
    private int total;

    public Item_in_loan(int image_view, String brand, int total) {
        this.image_view = image_view;
        this.brand = brand;
        this.total = total;
    }

    public int getImage_view() {
        return image_view;
    }

    public String getBrand() {
        return brand;
    }

    public int getTotal() {
        return total;
    }

    public void setImage_view(int image_view) {
        this.image_view = image_view;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

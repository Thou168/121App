package com.example.a121firstapp.Class_item;

public class Item_in_like {

    private int image_view;
    private String brand,location;
    private  int total;

    public Item_in_like(int image_view, String brand, int total,String location) {
        this.image_view = image_view;
        this.brand = brand;
        this.total = total;
        this.location=location;
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
    public String getLocation(){return location;}
    public void setImage_view(int image_view) {
        this.image_view = image_view;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public void setLocation(String location){this.location=location;}
}

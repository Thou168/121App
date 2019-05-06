package com.example.a121firstapp.Class_item;

public class Item_order_list {

    private int img_view;
    private String brand;
    private double price,amt_request;
    private String name,condition;

    public Item_order_list(int img_view, String brand, double price, String name, String condition, double amt_request) {
        this.img_view = img_view;
        this.brand = brand;
        this.price = price;
        this.amt_request = amt_request;
        this.name = name;
        this.condition = condition;
    }

    public int getImg_view() {
        return img_view;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public double getAmt_request() {
        return amt_request;
    }

    public String getName() {
        return name;
    }

    public String getCondition() {
        return condition;
    }

    public void setImg_view(int img_view) {
        this.img_view = img_view;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmt_request(double amt_request) {
        this.amt_request = amt_request;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}

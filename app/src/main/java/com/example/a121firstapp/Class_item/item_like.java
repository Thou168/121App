package com.example.a121firstapp.Class_item;

public class item_like {
    private int img_v;
    private String title;
    private Double price;

    public item_like(int img_v, String title, Double price) {
        this.img_v = img_v;
        this.title = title;
        this.price = price;
    }

    public int getImg_v() {
        return img_v;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public void setImg_v(int img_v) {
        this.img_v = img_v;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

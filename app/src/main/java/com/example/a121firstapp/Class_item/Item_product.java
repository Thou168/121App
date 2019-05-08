package com.example.a121firstapp.Class_item;

public class Item_product {
    private String image;
    private String name;
    private String price;

    public Item_product() {
    }

    public Item_product(String image, String name, String price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

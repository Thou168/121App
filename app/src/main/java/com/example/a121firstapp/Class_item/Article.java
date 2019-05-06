package com.example.a121firstapp.Class_item;

/**
 * Created by BOUMZEBRA on 27/02/2018.
 */

public class Article {
    private Integer id;
    private String name;
    private String posts;
    private int image;
    private String price;
    private String color;
    private String brand;
    private String category;
    private String year;

    public Article(int id, String name, String posts, int image, String price, String color, String brand, String category, String year) {
        this.id = id;
        this.name = name;
        this.posts = posts;
        this.image = image;
        this.price = price;
        this.color = color;
        this.brand = brand;
        this.category = category;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosts() {
        return posts;
    }

    public void setPosts(String posts) {
        this.posts = posts;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }

    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }

    public String getYear(){
        return year;
    }
    public void setYear(){
        this.year = year;
    }

}

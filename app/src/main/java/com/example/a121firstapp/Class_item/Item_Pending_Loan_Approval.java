package com.example.a121firstapp.Class_item;

public class Item_Pending_Loan_Approval {

    private String name, post;
    private int pic;
    private double price;

    private String description,tax,brand,year;
    private double amount;

    public Item_Pending_Loan_Approval(String name, String post, int pic, double price, String description, String tax, String brand, String year, double amount) {
        this.name = name;
        this.post = post;
        this.pic = pic;
        this.price = price;
        this.description = description;
        this.tax = tax;
        this.brand = brand;
        this.year = year;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getPic(){
        return pic;
    }

    public void setPic(int pic){
        this.pic = pic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

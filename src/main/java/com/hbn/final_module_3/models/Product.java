package com.hbn.final_module_3.models;

public class Product {
    private int id;
    private String productName;
    private int price;
    private double discount;
    private int stock;

    public Product(String productName, int price, double discount, int stock) {
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

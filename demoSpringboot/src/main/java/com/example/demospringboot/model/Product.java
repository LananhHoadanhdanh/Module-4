package com.example.demospringboot.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long price;
    private int quantity;
    private String color;
    private String img;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Product() {
    }

    public Product(String name, long price, int quantity, String color, Category category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public Product(String name, long price, int quantity, String color, String img, Category category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.img = img;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

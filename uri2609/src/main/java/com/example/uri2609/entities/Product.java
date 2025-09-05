package com.example.uri2609.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private Long id;
    private String name;
    private Integer amount;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_categories")
    private Category category;

    public Product() {}

    public Product(Long id, String name, Integer amount, BigDecimal price, Category catgory) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.category = catgory;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCatgory() {
        return category;
    }

    public void setCatgory(Category catgory) {
        this.category = catgory;
    }
}

package com.xiao.java8.reflect;

import java.math.BigDecimal;

@Alias(value = "products" , isGenerator = true)
public class Product {

    @Alias(value = "pro_id" , isGenerator = false)
    private int id;

    @Alias(value = "pro_name")
    private String name;

    private BigDecimal price;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}